package ch.nteinno.frwdeluxe.frwdeluxe.server.user;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.IUserTableService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.UserTableTablePageData;
import org.eclipse.scout.rt.platform.holders.NVPair;
import org.eclipse.scout.rt.server.jdbc.SQL;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class UserTableService implements IUserTableService {
  @Override
  public UserTableTablePageData getUserTableTableData(SearchFilter filter) {
    UserTableTablePageData pageData = new UserTableTablePageData();

    String query = """
      select user_nr, username, status_uid from "user"
      into :{page.userNr},
           :{page.username},
           :{page.status}
      """;

    SQL.selectInto(query, new NVPair("page", pageData));

    return pageData;
  }
}
