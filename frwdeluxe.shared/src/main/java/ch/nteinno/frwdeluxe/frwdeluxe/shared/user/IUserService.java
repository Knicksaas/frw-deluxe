package ch.nteinno.frwdeluxe.frwdeluxe.shared.user;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

@TunnelToServer
public interface IUserService extends IService {

    UserFormData prepareCreate(UserFormData formData);

  UserFormData create(UserFormData formData);

  UserFormData load(UserFormData formData);

  UserFormData store(UserFormData formData);

  boolean checkCredentials(String username, String passwordHash);

  boolean isUsernameAvailable(String username);

  void createUser(String username, String password);

  Long getUserNumberByUsername(String username);
}
