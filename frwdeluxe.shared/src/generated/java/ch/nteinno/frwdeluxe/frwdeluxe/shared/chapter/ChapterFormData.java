package ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter;

import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.properties.AbstractPropertyData;

import javax.annotation.Generated;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 */
@ClassId("5ba37726-8989-4ba8-82b4-21b3e4896cbf-formdata")
@Generated(value = "ch.nteinno.frwdeluxe.frwdeluxe.client.chapter.ChapterForm", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class ChapterFormData extends AbstractFormData {
    private static final long serialVersionUID = 1L;

    public ChapterName getChapterName() {
        return getFieldByClass(ChapterName.class);
    }

    /**
     * access method for property ChapterNr.
     */
    public Long getChapterNr() {
        return getChapterNrProperty().getValue();
    }

    /**
     * access method for property ChapterNr.
     */
    public void setChapterNr(Long chapterNr) {
        getChapterNrProperty().setValue(chapterNr);
    }

    public ChapterNrProperty getChapterNrProperty() {
        return getPropertyByClass(ChapterNrProperty.class);
    }

    @ClassId("c2af7d64-bf7b-4efc-a569-c8f74dfd3209-formdata")
    public static class ChapterName extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }

    public static class ChapterNrProperty extends AbstractPropertyData<Long> {
        private static final long serialVersionUID = 1L;
    }
}
