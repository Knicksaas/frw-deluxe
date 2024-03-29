package ch.nteinno.frwdeluxe.frwdeluxe.shared.user;

import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.properties.AbstractPropertyData;

import javax.annotation.Generated;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 */
@ClassId("5c8a3591-d0fb-41a5-8156-37599ed695bc-formdata")
@Generated(value = "ch.nteinno.frwdeluxe.frwdeluxe.client.user.UserForm", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class UserFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public Password getPassword() {
    return getFieldByClass(Password.class);
  }

  /**
   * access method for property UserNr.
   */
  public Long getUserNr() {
    return getUserNrProperty().getValue();
  }

  /**
   * access method for property UserNr.
   */
  public void setUserNr(Long userNr) {
    getUserNrProperty().setValue(userNr);
  }

  public UserNrProperty getUserNrProperty() {
    return getPropertyByClass(UserNrProperty.class);
  }

  public Username getUsername() {
    return getFieldByClass(Username.class);
  }

  @ClassId("f9c25a11-1455-49d6-8736-3ccedc848609-formdata")
  public static class Password extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;
  }

  public static class UserNrProperty extends AbstractPropertyData<Long> {
    private static final long serialVersionUID = 1L;
  }

  @ClassId("78821539-c186-4f6a-8755-ad2a09878d07-formdata")
  public static class Username extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;
  }
}
