package ch.nteinno.frwdeluxe.frwdeluxe.server.security;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.security.AccessControlService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.CreateUserPermission;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.ReadUserPermission;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.UpdateUserPermission;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Platform;
import org.eclipse.scout.rt.platform.Replace;
import org.eclipse.scout.rt.security.DefaultPermissionCollection;
import org.eclipse.scout.rt.security.IPermissionCollection;
import org.eclipse.scout.rt.security.PermissionLevel;
import org.eclipse.scout.rt.shared.security.RemoteServiceAccessPermission;

/**
 * @author nsd
 */
@Replace
public class ServerAccessControlService extends AccessControlService {

  @Override
  protected IPermissionCollection execLoadPermissions(String userId) {
    IPermissionCollection permissions = BEANS.get(DefaultPermissionCollection.class);
    permissions.add(new RemoteServiceAccessPermission("*.shared.*", "*"), PermissionLevel.ALL);

    if (userId.equals("admin") || Platform.get().inDevelopmentMode()) {
      permissions.add(new ReadUserPermission(), PermissionLevel.ALL);
      permissions.add(new CreateUserPermission(), PermissionLevel.ALL);
      permissions.add(new UpdateUserPermission(), PermissionLevel.ALL);
    }

    permissions.setReadOnly();
    return permissions;
  }
}
