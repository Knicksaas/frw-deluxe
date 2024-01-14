package ch.nteinno.frwdeluxe.frwdeluxe.shared.user;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

@TunnelToServer
public interface IUserTableService extends IService {
    UserTableTablePageData getUserTableTableData(SearchFilter filter);
}
