package ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact;

import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

import javax.annotation.Generated;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 */
@ClassId("4312919f-fff7-43b8-9adc-f59b7badf78b-formdata")
@Generated(value = "ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact.BookingFactSearchForm", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class BookingFactSearchFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public ChapterNr getChapterNr() {
    return getFieldByClass(ChapterNr.class);
  }

  @ClassId("3f802801-c263-466f-967f-d62ce4545d5c-formdata")
  public static class ChapterNr extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;
  }
}
