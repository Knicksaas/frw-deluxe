package ch.nteinno.frwdeluxe.frwdeluxe.client.chapter;

import ch.nteinno.frwdeluxe.frwdeluxe.client.chapter.ChapterForm.MainBox.CancelButton;
import ch.nteinno.frwdeluxe.frwdeluxe.client.chapter.ChapterForm.MainBox.GroupBox;
import ch.nteinno.frwdeluxe.frwdeluxe.client.chapter.ChapterForm.MainBox.OkButton;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter.ChapterFormData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter.IChapterService;
import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;

@ClassId("5ba37726-8989-4ba8-82b4-21b3e4896cbf")
@FormData(value = ChapterFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class ChapterForm extends AbstractForm {

  private Long m_chapterNr;

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
    return TEXTS.get("Chapter");
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public GroupBox getGroupBox() {
    return getFieldByClass(GroupBox.class);
  }

  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  public GroupBox.ChapterNameField getChapterNameField() {
    return getFieldByClass(GroupBox.ChapterNameField.class);
  }

  @Order(1000)
  @ClassId("af338895-2088-40a8-b721-4a07e272255c")
  public class MainBox extends AbstractGroupBox {

    @Override
    protected int getConfiguredGridColumnCount() {
      return 1;
    }

    @Order(1000)
    @ClassId("1e5f3b79-40a3-47f5-9609-f6db7fb3c45d")
    public class GroupBox extends AbstractGroupBox {

      @Order(1000)
      @ClassId("c2af7d64-bf7b-4efc-a569-c8f74dfd3209")
      public class ChapterNameField extends AbstractStringField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Name");
        }

        @Override
        protected boolean getConfiguredMandatory() {
          return true;
        }
      }
    }

    @Order(2000)
    @ClassId("5e3514b2-a3a7-41e5-8841-487f12f3ec3a")
    public class OkButton extends AbstractOkButton {

    }

    @Order(3000)
    @ClassId("4ea0aa4d-bcf9-406c-8478-14e00e6ef40a")
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
      ChapterFormData formData = new ChapterFormData();
      exportFormData(formData);
      formData = BEANS.get(IChapterService.class).prepareCreate(formData);
      importFormData(formData);
    }

    @Override
    protected void execStore() {
      ChapterFormData formData = new ChapterFormData();
      exportFormData(formData);
      formData = BEANS.get(IChapterService.class).create(formData);
      importFormData(formData);
    }
  }

  public class ModifyHandler extends AbstractFormHandler {
    @Override
    protected void execLoad() {
      ChapterFormData formData = new ChapterFormData();
      exportFormData(formData);
      formData = BEANS.get(IChapterService.class).load(formData);
      importFormData(formData);
    }

    @Override
    protected void execStore() {
      ChapterFormData formData = new ChapterFormData();
      exportFormData(formData);
      formData = BEANS.get(IChapterService.class).store(formData);
      importFormData(formData);
    }
  }
}
