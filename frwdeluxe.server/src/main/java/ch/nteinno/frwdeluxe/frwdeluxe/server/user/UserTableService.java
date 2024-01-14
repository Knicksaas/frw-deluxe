package ch.nteinno.frwdeluxe.frwdeluxe.server.user;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.IUserTableService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.UserTableTablePageData;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class UserTableService implements IUserTableService {
    @Override
    public UserTableTablePageData getUserTableTableData(SearchFilter filter) {
        UserTableTablePageData pageData = new UserTableTablePageData();
// TODO [nsd] fill pageData.
        return pageData;
    }
}
