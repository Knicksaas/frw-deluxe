package ch.nteinno.frwdeluxe.frwdeluxe.server.user;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.*;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.security.ACCESS;

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
    public boolean checkCredentials(String username, String passwordHash) {
        return false;
    }
}
