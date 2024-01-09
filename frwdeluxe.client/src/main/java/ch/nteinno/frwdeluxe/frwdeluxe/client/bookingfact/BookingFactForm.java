package ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact;

import ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact.BookingFactForm.MainBox.CancelButton;
import ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact.BookingFactForm.MainBox.GroupBox;
import ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact.BookingFactForm.MainBox.OkButton;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.BookingFactFormData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.IBookingFactService;
import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;

@ClassId("9b68d4f3-afdf-4c8c-8fa0-f26ff768c9c0")
@FormData(value = BookingFactFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class BookingFactForm extends AbstractForm {

  private Long m_bookingFactNr;
  private Long m_chapterNr;

  @FormData
  public Long getBookingFactNr() {
    return m_bookingFactNr;
  }

  @FormData
  public void setBookingFactNr(Long bookingFactNr) {
    m_bookingFactNr = bookingFactNr;
  }

  @FormData
  public Long getChapterNr() {
    return m_chapterNr;
  }

  @FormData
  public void setChapterNr(Long chapterNr) {
    m_chapterNr = chapterNr;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("BookingEntry");
  }

  public GroupBox.BookingFactBox getBookingFactBox() {
    return getFieldByClass(GroupBox.BookingFactBox.class);
  }


  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public GroupBox getGroupBox() {
    return getFieldByClass(GroupBox.class);
  }

  public AbstractStringField getBookingFactField() {
    return getFieldByClass(GroupBox.BookingFactBox.BookingFactField.class);
  }

  public AbstractStringField getShouldField() {
    return getFieldByClass(GroupBox.ShouldHaveBox.ShouldField.class);
  }

  public AbstractStringField getHaveField() {
    return getFieldByClass(GroupBox.ShouldHaveBox.HaveField.class);
  }

  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  public GroupBox.BookingFactBox.ChapterField getChapterField() {
    return getFieldByClass(GroupBox.BookingFactBox.ChapterField.class);
  }


  @Order(1000)
  @ClassId("2c33cb6a-3a05-4b05-a8b0-f4edd0945db0")
  public class MainBox extends AbstractGroupBox {

    @Override
    protected boolean getConfiguredEnabled() {
      return true;
    }

    @Order(1000)
    @ClassId("c1f07167-9d0f-4cb2-8b30-0e5293fe8dd2")
    public class GroupBox extends AbstractGroupBox {

      @Override
      protected boolean getConfiguredEnabled() {
        return true;
      }

      @Override
      protected int getConfiguredGridColumnCount() {
        return 2;
      }

      @Order(0)
      @ClassId("dc39c7f9-f5fd-495d-8b6a-391e6c694b9c")
      public class BookingFactBox extends AbstractGroupBox {
        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
        }

        @Override
        protected int getConfiguredGridW() {
          return 1;
        }

        @Override
        protected int getConfiguredGridColumnCount() {
          return 1;
        }

        @Order(0)
        @ClassId("908c52eb-bcbf-4c66-9990-4e0d9b515d46")
        public class ChapterField extends AbstractSmartField<Long> {
          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Chapter");
          }

          @Override
          protected boolean getConfiguredVisible() {
            return false;
          }
        }

        @Order(1000)
        @ClassId("e30fd8f8-6263-41c6-9d7d-6260dce8d5ae")
        public class BookingFactField extends AbstractStringField {
          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("BookingFact");
          }

          @Override
          protected boolean getConfiguredMultilineText() {
            return true;
          }

          @Override
          protected int getConfiguredGridH() {
            return 2;
          }

          @Override
          protected boolean getConfiguredMandatory() {
            return true;
          }
        }
      }

      @Order(1000)
      @ClassId("3de566ef-17c1-4f80-9b2a-75c254ad0eef")
      public class ShouldHaveBox extends AbstractGroupBox {

        @Override
        protected int getConfiguredGridW() {
          return 1;
        }

        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
        }

        @Override
        protected int getConfiguredGridColumnCount() {
          return 1;
        }

        @Order(2000)
        @ClassId("11957890-e698-4312-bf2d-1644ee971dcc")
        public class ShouldField extends AbstractStringField {
          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Should");
          }

          @Override
          protected boolean getConfiguredMandatory() {
            return true;
          }
        }

        @Order(3000)
        @ClassId("3afe8bcb-00cc-46f4-bdcf-653343ebc35b")
        public class HaveField extends AbstractStringField {
          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Have");
          }

          @Override
          protected boolean getConfiguredMandatory() {
            return true;
          }
        }
      }

    }

    @Order(2000)
    @ClassId("09bcfa7d-d0a5-44f8-8fd5-4d6617a0dc6b")
    public class OkButton extends AbstractOkButton {

    }

    @Order(3000)
    @ClassId("c5bf4176-c945-4948-b210-5d4514bf7a46")
    public class CancelButton extends AbstractCancelButton {

    }
  }

  public void startModify() {
    startInternalExclusive(new ModifyHandler());
  }

  public void startNew() {
    startInternal(new NewHandler());
  }

  public class NewHandler extends AbstractFormHandler {
    @Override
    protected void execLoad() {
      BookingFactFormData formData = new BookingFactFormData();
      exportFormData(formData);
      formData = BEANS.get(IBookingFactService.class).prepareCreate(formData);
      importFormData(formData);
    }

    @Override
    protected void execStore() {
      BookingFactFormData formData = new BookingFactFormData();
      exportFormData(formData);
      formData = BEANS.get(IBookingFactService.class).create(formData);
      importFormData(formData);
    }
  }

  public class ModifyHandler extends AbstractFormHandler {
    @Override
    protected void execLoad() {
      BookingFactFormData formData = new BookingFactFormData();
      exportFormData(formData);
      formData = BEANS.get(IBookingFactService.class).load(formData);
      importFormData(formData);
    }

    @Override
    protected void execStore() {
      BookingFactFormData formData = new BookingFactFormData();
      exportFormData(formData);
      formData = BEANS.get(IBookingFactService.class).store(formData);
      importFormData(formData);
    }
  }
}
