package ch.nteinno.frwdeluxe.frwdeluxe.client.user;

import ch.nteinno.frwdeluxe.frwdeluxe.client.common.AbstractFrwDeluxeTablePage;
import ch.nteinno.frwdeluxe.frwdeluxe.client.user.UserTableTablePage.Table;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.Icons;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.IUserTableService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.ReadUserPermission;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.UserTableTablePageData;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.CollectionUtility;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

import java.util.Set;

@Data(UserTableTablePageData.class)
@ClassId("16cb9de9-60e7-432e-a854-3b47d57ba95c")
public class UserTableTablePage extends AbstractFrwDeluxeTablePage<Table> {

  @Override
  protected void execInitPage() {
    setVisiblePermission(new ReadUserPermission());
  }

  @Override
  protected boolean getConfiguredLeaf() {
    return false;
  }

  @Override
  protected String getConfiguredIconId() {
    return Icons.PersonSolid;
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

    @Override
    protected Class<? extends IMenu> getConfiguredDefaultMenu() {
      return EditUserMenu.class;
    }

    @Override
    protected boolean getConfiguredAutoResizeColumns() {
      return true;
    }

    public StatusColumn getStatusColumn() {
      return getColumnSet().getColumnByClass(StatusColumn.class);
    }

    public UserNrColumn getUserNrColumn() {
      return getColumnSet().getColumnByClass(UserNrColumn.class);
    }

    public UsernameColumn getUsernameColumn() {
      return getColumnSet().getColumnByClass(UsernameColumn.class);
    }

    @Order(1000)
    @ClassId("156f4e2d-211e-4592-811a-898cea1328b3")
    public class UserNrColumn extends AbstractLongColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("UserNr");
      }

      @Override
      protected int getConfiguredWidth() {
        return 50;
      }
    }

    @Order(2000)
    @ClassId("ebaa4503-3f23-4970-88e0-6a52ac95cb5c")
    public class UsernameColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Username");
      }

      @Override
      protected int getConfiguredWidth() {
        return 500;
      }
    }

    @Order(3000)
    @ClassId("142bc903-0c35-4872-8aed-4fb0be29bb07")
    public class StatusColumn extends AbstractLongColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Status");
      }

      @Override
      protected int getConfiguredWidth() {
        return 50;
      }

      @Override
      protected int getConfiguredHorizontalAlignment() {
        return -1;
      }
    }

    @Order(1000)
    @ClassId("8d93df87-e321-4274-ab60-5e56bbe8e90f")
    public class AddUserMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return TEXTS.get("AddUser");
      }

      @Override
      protected String getConfiguredIconId() {
        return Icons.Plus;
      }

      @Override
      protected Set<? extends IMenuType> getConfiguredMenuTypes() {
        return CollectionUtility.hashSet(TableMenuType.EmptySpace);
      }

      @Override
      protected void execAction() {
        UserForm form = new UserForm();
        form.addFormListener(UserTableTablePage.this);
        form.startNew();
      }
    }

    @Order(2000)
    @ClassId("82c93c11-b8f3-4deb-9488-f07129992ea7")
    public class EditUserMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return TEXTS.get("EditUser");
      }

      @Override
      protected String getConfiguredIconId() {
        return Icons.Pencil;
      }

      @Override
      protected Set<? extends IMenuType> getConfiguredMenuTypes() {
        return CollectionUtility.hashSet(TableMenuType.SingleSelection);
      }

      @Override
      protected void execAction() {
        UserForm form = new UserForm();
        form.addFormListener(UserTableTablePage.this);
        form.setUserNr(getUserNrColumn().getSelectedValue());
        form.startModify();
      }
    }
  }
}

