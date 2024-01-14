package ch.nteinno.frwdeluxe.frwdeluxe.client.user;

import ch.nteinno.frwdeluxe.frwdeluxe.client.user.UserTableTablePage.Table;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.IUserTableService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.UserTableTablePageData;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

@Data(UserTableTablePageData.class)
@ClassId("16cb9de9-60e7-432e-a854-3b47d57ba95c")
public class UserTableTablePage extends AbstractPageWithTable<Table> {
    @Override
    protected boolean getConfiguredLeaf() {
        return true;
    }

    @Override
    protected void execLoadData(SearchFilter filter) {
        importPageData(BEANS.get(IUserTableService.class).getUserTableTableData(filter));
    }

    @Override
    protected String getConfiguredTitle() {
        return TEXTS.get("User");
    }

    @ClassId("17234193-9518-413b-a274-ced3e18ce4a2")
    public class Table extends AbstractTable {

    }
}
