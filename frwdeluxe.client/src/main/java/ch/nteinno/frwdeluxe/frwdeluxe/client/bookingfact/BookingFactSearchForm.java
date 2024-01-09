package ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact;

import ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact.BookingFactSearchForm.MainBox.GroupBox;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.BookingFactSearchFormData;
import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractSearchForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractResetButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractSearchButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.longfield.AbstractLongField;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;

@ClassId("4312919f-fff7-43b8-9adc-f59b7badf78b")
@FormData(value = BookingFactSearchFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class BookingFactSearchForm extends AbstractSearchForm {

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public GroupBox getGroupBox() {
    return getFieldByClass(GroupBox.class);
  }

  public MainBox.SearchButton getOkButton() {
    return getFieldByClass(MainBox.SearchButton.class);
  }

  public MainBox.ResetButton getCancelButton() {
    return getFieldByClass(MainBox.ResetButton.class);
  }

  public GroupBox.ChapterNrField getChapterNrField() {
    return getFieldByClass(GroupBox.ChapterNrField.class);
  }

  @Order(1000)
  @ClassId("ce89d5e3-d82f-4ed8-8153-599ba6ac6f56")
  public class MainBox extends AbstractGroupBox {
    @Order(1000)
    @ClassId("b760b690-3af5-45e5-af4d-2153f18bd4e6")
    public class GroupBox extends AbstractGroupBox {

      @Order(1000)
      @ClassId("3f802801-c263-466f-967f-d62ce4545d5c")
      public class ChapterNrField extends AbstractLongField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Chapter");
        }

        @Override
        protected boolean getConfiguredVisible() {
          return false;
        }
      }
    }

    @Order(2000)
    @ClassId("393e76c9-beb6-4d51-9341-bb136db53f8a")
    public class SearchButton extends AbstractSearchButton {

    }

    @Order(3000)
    @ClassId("f2f1d07a-84e4-4a05-a7ca-f6b330de5342")
    public class ResetButton extends AbstractResetButton {

    }
  }

  public void startSearch() {
    startInternal(new SearchHandler());
  }

  public class SearchHandler extends AbstractFormHandler {
    @Override
    protected void execLoad() {
    }
  }
}
