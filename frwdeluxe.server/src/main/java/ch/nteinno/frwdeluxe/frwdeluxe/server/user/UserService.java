package ch.nteinno.frwdeluxe.frwdeluxe.server.user;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.*;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.holders.NVPair;
import org.eclipse.scout.rt.platform.security.SecurityUtility;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.Base64Utility;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.eclipse.scout.rt.security.ACCESS;
import org.eclipse.scout.rt.server.jdbc.SQL;

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

        byte[] correctPasswordHash = Base64Utility.decode(String.valueOf(result[0][0]));
        byte[] passwordSalt = Base64Utility.decode(String.valueOf(result[0][1]));

        return SecurityUtility.verifyPasswordHash(password.toCharArray(), passwordSalt, correctPasswordHash);
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return getUserNumberByUsername(username) != null;
    }

    @Override
    public void createUser(String username, String password) {
      if (!isUsernameAvailable(username)) {
        return;
      }

      byte[] salt = SecurityUtility.createRandomBytes();
      byte[] passwordHash = SecurityUtility.hashPassword(password.toCharArray(), salt);

      NVPair usernameBind = new NVPair("username", username);
      NVPair passwordHashBind = new NVPair("passwordHash", Base64Utility.encode(passwordHash));
      NVPair saltBind = new NVPair("salt", Base64Utility.encode(salt));
      SQL.insert("""
        INSERT INTO "user" (username, password_hash, password_salt, status_uid)
        VALUES (:username, :passwordHash, :salt, 101);
        """, usernameBind, passwordHashBind, saltBind);
    }

  @Override
  public Long getUserNumberByUsername(String username) {
    if (StringUtility.isNullOrEmpty(username)) {
      return null;
    }

    NVPair usernamePair = new NVPair("username", username);
    Object[][] result = SQL.select("""
      select user_nr from "user" where username = :username
      """, usernamePair);

    if (result.length < 1) {
      return null;
    }

    return ((Long) result[0][0]);
  }
}
