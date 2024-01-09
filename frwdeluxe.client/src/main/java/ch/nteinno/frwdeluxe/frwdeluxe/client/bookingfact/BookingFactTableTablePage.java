package ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact;

import ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact.BookingFactTableTablePage.Table;
import ch.nteinno.frwdeluxe.frwdeluxe.client.common.AbstractFrwDeluxeTablePage;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.Icons;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.BookingFactTableTablePageData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.IBookingFactTableService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.reveal.IRevealService;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.basic.cell.Cell;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractBooleanColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPageWithTable;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.html.HTML;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.CollectionUtility;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Data(BookingFactTableTablePageData.class)
@ClassId("167d991f-1911-447b-8b54-131b508a67bf")
public class BookingFactTableTablePage extends AbstractFrwDeluxeTablePage<Table> {

  private Long m_chapterNr;

  public Long getChapterNr() {
    return m_chapterNr;
  }

  public void setChapterNr(Long chapterNr) {
    m_chapterNr = chapterNr;
  }

  @Override
  protected boolean getConfiguredLeaf() {
    return true;
  }

  @Override
  protected void execLoadData(SearchFilter filter) {
    importPageData(BEANS.get(IBookingFactTableService.class).getBookingFactTableTableData(filter));
  }

  @Override
  protected List<IMenu> execComputeParentTablePageMenus(IPageWithTable<?> parentTablePage) {
    return Collections.emptyList();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("BookingFact");
  }

  @ClassId("4a67bfbd-0490-4f0a-9960-2064e6120705")
  public class Table extends AbstractTable {

    @Override
    protected String getConfiguredCssClass() {
      return "booking-fact-table";
    }

    @Override
    protected boolean getConfiguredAutoResizeColumns() {
      return true;
    }

    @Override
    protected void execAppLinkAction(String ref) {
      switch (ref) {
        case "SHOULD" -> {
          getRevealedShouldColumn().setValue(getSelectedRow(), true);
          getShouldColumn().refreshValues();
          BEANS.get(IRevealService.class).revealBookingFact(
            getKeyColumn().getSelectedValue(),
            true,
            getRevealedHaveColumn().getSelectedValue());
        }
        case "HAVE" -> {
          getRevealedHaveColumn().setValue(getSelectedRow(), true);
          getHaveColumn().refreshValues();
          BEANS.get(IRevealService.class).revealBookingFact(
            getKeyColumn().getSelectedValue(),
            getRevealedShouldColumn().getSelectedValue(),
            true);
        }
      }
    }

    public BookingFactColumn getBookingFactColumn() {
      return getColumnSet().getColumnByClass(BookingFactColumn.class);
    }

    public HaveColumn getHaveColumn() {
      return getColumnSet().getColumnByClass(HaveColumn.class);
    }

    public KeyColumn getKeyColumn() {
      return getColumnSet().getColumnByClass(KeyColumn.class);
    }

    public RevealedHaveColumn getRevealedHaveColumn() {
      return getColumnSet().getColumnByClass(RevealedHaveColumn.class);
    }

    public RevealedShouldColumn getRevealedShouldColumn() {
      return getColumnSet().getColumnByClass(RevealedShouldColumn.class);
    }

    public ShouldColumn getShouldColumn() {
      return getColumnSet().getColumnByClass(ShouldColumn.class);
    }

    @Order(1000)
    @ClassId("57d0f161-9b3f-4082-81a5-5e24eac522e8")
    public class KeyColumn extends AbstractLongColumn {
      @Override
      protected boolean getConfiguredVisible() {
        return false;
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(2000)
    @ClassId("ecc82ded-8adf-4e35-ae45-f580a7636a11")
    public class BookingFactColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("BookingFact");
      }

      @Override
      protected int getConfiguredWidth() {
        return 300;
      }
    }

    @Order(2500)
    @ClassId("d798e818-7025-42c7-9dcc-d323f84749ef")
    public class RevealedShouldColumn extends AbstractBooleanColumn {
      @Override
      protected boolean getConfiguredDisplayable() {
        return false;
      }
    }

    @Order(3000)
    @ClassId("45abee3e-d0d6-467c-8125-da09c8f90226")
    public class ShouldColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Should");
      }

      @Override
      protected void execDecorateCell(Cell cell, ITableRow row) {
        if (!getRevealedShouldColumn().getValue(row)) {
          cell.setText(HTML.appLink("SHOULD", TEXTS.get("ClickToReveal")).toHtml());
        } else {
          cell.setText(HTML.span(getShouldColumn().getValue(row)).cssClass("text").toHtml());
        }
      }

      @Override
      protected boolean getConfiguredHtmlEnabled() {
        return true;
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(3500)
    @ClassId("91a923d5-8770-489c-b67d-c687062fae56")
    public class RevealedHaveColumn extends AbstractBooleanColumn {
      @Override
      protected boolean getConfiguredDisplayable() {
        return false;
      }
    }

    @Order(4000)
    @ClassId("7e4135e9-a637-4b8b-a90f-0bc5270c805c")
    public class HaveColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Have");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }

      @Override
      protected void execDecorateCell(Cell cell, ITableRow row) {
        if (!getRevealedHaveColumn().getValue(row)) {
          cell.setText(HTML.appLink("HAVE", TEXTS.get("ClickToReveal")).toHtml());
        } else {
          cell.setText(HTML.span(getHaveColumn().getValue(row)).cssClass("text").toHtml());
        }
      }

      @Override
      protected boolean getConfiguredHtmlEnabled() {
        return true;
      }
    }

    @Order(1000)
    @ClassId("22dc131b-82b9-4789-9eab-6cfcab8f5bdc")
    public class NewBookingFactMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return TEXTS.get("AddBookingFact");
      }

      @Override
      protected Set<? extends IMenuType> getConfiguredMenuTypes() {
        return CollectionUtility.hashSet(TableMenuType.EmptySpace);
      }

      @Override
      protected String getConfiguredIconId() {
        return Icons.Plus;
      }

      @Override
      protected void execAction() {
        BookingFactForm form = new BookingFactForm();
        form.addFormListener(BookingFactTableTablePage.this);
        form.addFormListener(((AbstractFrwDeluxeTablePage<?>) BookingFactTableTablePage.this.getParentPage()));
        form.setChapterNr(getChapterNr());
        form.startNew();
      }
    }

    @Order(2000)
    @ClassId("7559e27d-ddc0-4e1a-82e8-172118caa79b")
    public class EditBookingFactMenu extends AbstractMenu {
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
        BookingFactForm form = new BookingFactForm();
        form.addFormListener(BookingFactTableTablePage.this);
        form.addFormListener(((AbstractFrwDeluxeTablePage<?>) BookingFactTableTablePage.this.getParentPage()));
        form.setBookingFactNr(getKeyColumn().getSelectedValue());
        form.startModify();
      }
    }

    @Order(3000)
    @ClassId("a988411f-0abb-4e6d-bccb-20b7fd275684")
    public class UnrevealAllMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return TEXTS.get("UnrevealAll");
      }

      @Override
      protected Set<? extends IMenuType> getConfiguredMenuTypes() {
        return CollectionUtility.hashSet(TableMenuType.EmptySpace);
      }

      @Override
      protected void execAction() {

      }
    }
  }
}
