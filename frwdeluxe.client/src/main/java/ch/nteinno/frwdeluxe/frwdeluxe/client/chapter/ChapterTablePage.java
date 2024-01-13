package ch.nteinno.frwdeluxe.frwdeluxe.client.chapter;

import ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact.BookingFactSearchForm;
import ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact.BookingFactTableTablePage;
import ch.nteinno.frwdeluxe.frwdeluxe.client.chapter.ChapterTablePage.Table;
import ch.nteinno.frwdeluxe.frwdeluxe.client.common.AbstractFrwDeluxeTablePage;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.Icons;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter.ChapterTableTablePageData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter.IChapterTableService;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.CollectionUtility;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

import java.util.Set;

@Data(ChapterTableTablePageData.class)
@ClassId("cfd26390-1796-4bcc-af9d-b9f66bfa55e7")
public class ChapterTablePage extends AbstractFrwDeluxeTablePage<Table> {

  @Override
  protected String getConfiguredIconId() {
    return Icons.Folder;
  }

  @Override
  protected boolean getConfiguredLeaf() {
    return false;
  }

  @Override
  protected void execLoadData(SearchFilter filter) {
    importPageData(BEANS.get(IChapterTableService.class).getChapterTableTableData(filter));
  }

  @Override
  protected IPage<?> execCreateChildPage(ITableRow row) {
    BookingFactTableTablePage page = new BookingFactTableTablePage();
    BookingFactSearchForm searchForm = new BookingFactSearchForm();
    searchForm.getChapterNrField().setValue(getTable().getIdColumn().getValue(row));
    page.setSearchForm(searchForm);
    page.setChapterNr(getTable().getIdColumn().getValue(row));
    return page;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("BookingFactTableTablePage");
  }

  @ClassId("f5da6c3f-3339-434c-ba0a-670cb2e7ab7d")
  public class Table extends AbstractTable {

    @Override
    protected boolean getConfiguredAutoResizeColumns() {
      return true;
    }

    public BookingFactCountColumn getBookingFactCountColumn() {
      return getColumnSet().getColumnByClass(BookingFactCountColumn.class);
    }

    public ChapterNameColumn getChapterNameColumn() {
      return getColumnSet().getColumnByClass(ChapterNameColumn.class);
    }

    public IdColumn getIdColumn() {
      return getColumnSet().getColumnByClass(IdColumn.class);
    }

    @Order(1000)
    @ClassId("92d9e7a5-31c6-40b8-8e00-160e6773efbc")
    public class IdColumn extends AbstractLongColumn {

      @Override
      protected boolean getConfiguredVisible() {
        return false;
      }
    }

    @Order(2000)
    @ClassId("dceb3b18-78b6-45a2-8f1b-d2de1cf46486")
    public class ChapterNameColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Chapter");
      }

      @Override
      protected int getConfiguredWidth() {
        return 300;
      }

      @Override
      protected int getConfiguredSortIndex() {
        return 1;
      }
    }

    @Order(3000)
    @ClassId("5126cd12-7b42-4ed1-8edf-86e5268d3d8a")
    public class BookingFactCountColumn extends AbstractLongColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("BookingFactCount");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }

      @Override
      protected int getConfiguredHorizontalAlignment() {
        return -1;
      }
    }

    @Order(1000)
    @ClassId("28523a56-14fa-414e-aeee-1ba069cbe9cf")
    public class AddChapterMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return TEXTS.get("AddChapter");
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
        ChapterForm form = new ChapterForm();
        form.addFormListener(ChapterTablePage.this);
        form.startNew();
      }
    }

    @Order(2000)
    @ClassId("9ec30082-6d1f-4a8a-88f2-1d27e6876793")
    public class EditChapterMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return TEXTS.get("Edit");
      }

      @Override
      protected Set<? extends IMenuType> getConfiguredMenuTypes() {
        return CollectionUtility.hashSet(TableMenuType.SingleSelection);
      }

      @Override
      protected String getConfiguredIconId() {
        return Icons.Pencil;
      }

      @Override
      protected void execAction() {
        ChapterForm form = new ChapterForm();
        form.addFormListener(ChapterTablePage.this);
        form.setChapterNr(getIdColumn().getSelectedValue());
        form.startModify();
      }
    }
  }
}
