package ch.nteinno.frwdeluxe.frwdeluxe.server.user;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.*;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.holders.NVPair;
import org.eclipse.scout.rt.platform.security.SecurityUtility;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.eclipse.scout.rt.security.ACCESS;
import org.eclipse.scout.rt.server.jdbc.SQL;

import java.nio.charset.StandardCharsets;

public class UserService implements IUserService {
    @Override
    public UserFormData prepareCreate(UserFormData formData) {
        if (!ACCESS.check(new CreateUserPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
        return formData;
    }

    @Override
    public UserFormData create(UserFormData formData) {
        if (!ACCESS.check(new CreateUserPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
        return formData;
    }

    @Override
    public UserFormData load(UserFormData formData) {
        if (!ACCESS.check(new ReadUserPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
        return formData;
    }

    @Override
    public UserFormData store(UserFormData formData) {
        if (!ACCESS.check(new UpdateUserPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
        return formData;
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        if (StringUtility.isNullOrEmpty(username) || StringUtility.isNullOrEmpty(password)) {
            // No credentials provided
            return false;
        }

        NVPair usernamePair = new NVPair("username", username);
        Object[][] result = SQL.select("""
                select password_hash, password_salt from "user" where username = :username
                """, usernamePair);

        if (result.length != 1) {
            // No, or too many entreis
            return false;
        }

        byte[] correctPasswordHash = String.valueOf(result[0][0]).getBytes(StandardCharsets.UTF_8);
        byte[] passwordSalt = String.valueOf(result[0][1]).getBytes(StandardCharsets.UTF_8);

        return SecurityUtility.verifyPasswordHash(password.toCharArray(), passwordSalt, correctPasswordHash);
    }
}
