package ch.nteinno.frwdeluxe.frwdeluxe.client.user;

import ch.nteinno.frwdeluxe.frwdeluxe.client.user.UserForm.MainBox.CancelButton;
import ch.nteinno.frwdeluxe.frwdeluxe.client.user.UserForm.MainBox.GroupBox;
import ch.nteinno.frwdeluxe.frwdeluxe.client.user.UserForm.MainBox.OkButton;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.CreateUserPermission;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.IUserService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.UpdateUserPermission;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.UserFormData;
import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;

@ClassId("5c8a3591-d0fb-41a5-8156-37599ed695bc")
@FormData(value = UserFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class UserForm extends AbstractForm {
    @Override
    protected String getConfiguredTitle() {
        return TEXTS.get("User");
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

    @Order(1000)
    @ClassId("1327d584-8522-438b-8c21-0090d96e6156")
    public class MainBox extends AbstractGroupBox {
        @Order(1000)
        @ClassId("6e52b977-ec34-46c7-90ca-d535de1ad1ec")
        public class GroupBox extends AbstractGroupBox {

        }

        @Order(2000)
        @ClassId("ad4e3eeb-46d5-48c1-af91-134f7a6ab10a")
        public class OkButton extends AbstractOkButton {

        }

        @Order(3000)
        @ClassId("6a7b07a1-5933-4519-badd-b31b2e4fdcc1")
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
            UserFormData formData = new UserFormData();
            exportFormData(formData);
            formData = BEANS.get(IUserService.class).prepareCreate(formData);
            importFormData(formData);

            setEnabledPermission(new CreateUserPermission());
        }

        @Override
        protected void execStore() {
            UserFormData formData = new UserFormData();
            exportFormData(formData);
            formData = BEANS.get(IUserService.class).create(formData);
            importFormData(formData);
        }
    }

    public class ModifyHandler extends AbstractFormHandler {
        @Override
        protected void execLoad() {
            UserFormData formData = new UserFormData();
            exportFormData(formData);
            formData = BEANS.get(IUserService.class).load(formData);
            importFormData(formData);

            setEnabledPermission(new UpdateUserPermission());
        }

        @Override
        protected void execStore() {
            UserFormData formData = new UserFormData();
            exportFormData(formData);
            formData = BEANS.get(IUserService.class).store(formData);
            importFormData(formData);
        }
    }
}
