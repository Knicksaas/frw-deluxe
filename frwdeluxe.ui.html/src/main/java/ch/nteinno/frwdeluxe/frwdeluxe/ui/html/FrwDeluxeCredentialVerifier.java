package ch.nteinno.frwdeluxe.frwdeluxe.ui.html;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.IUserService;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.context.RunContext;
import org.eclipse.scout.rt.platform.context.RunContexts;
import org.eclipse.scout.rt.platform.context.RunWithRunContext;
import org.eclipse.scout.rt.platform.exception.PlatformException;
import org.eclipse.scout.rt.platform.security.ICredentialVerifier;
import org.eclipse.scout.rt.platform.security.SimplePrincipal;
import org.eclipse.scout.rt.platform.util.StringUtility;

import javax.security.auth.Subject;

@RunWithRunContext
public class FrwDeluxeCredentialVerifier implements ICredentialVerifier {

    @Override
    public int verify(String username, char[] password) {
        if (StringUtility.isNullOrEmpty(username) || StringUtility.isNullOrEmpty(new String(password))) {
            return ICredentialVerifier.AUTH_CREDENTIALS_REQUIRED;
        }
        try {
            return checkOnServer(username, new String(password));
        } catch (PlatformException e) {
            return ICredentialVerifier.AUTH_FAILED;
        }
    }

    private int checkOnServer(String username, String password) {
        Subject subject = new Subject();
        subject.getPrincipals().add(new SimplePrincipal("system"));
        subject.setReadOnly();
        RunContext runContext = RunContexts.copyCurrent(true).withSubject(subject);

        boolean checkSucessfull = runContext.call(() -> BEANS.get(IUserService.class).checkCredentials(username, password));

        return checkSucessfull ? ICredentialVerifier.AUTH_OK : ICredentialVerifier.AUTH_FORBIDDEN;
    }
}
