package ch.nteinno.frwdeluxe.frwdeluxe.server.chapter;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter.ChapterFormData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter.IChapterService;
import org.eclipse.scout.rt.server.jdbc.SQL;

public class ChapterService implements IChapterService {
  @Override
  public ChapterFormData prepareCreate(ChapterFormData formData) {
    return formData;
  }

  @Override
  public ChapterFormData create(ChapterFormData formData) {
    SQL.insert(
      """
        INSERT INTO chapter (name, status_uid)
        VALUES (:chapterName, 101);
        """, formData);

    return formData;
  }

  @Override
  public ChapterFormData load(ChapterFormData formData) {
    SQL.selectInto(
      """
          select name from chapter
          into :chapterName
          where chapter_nr = :chapterNr
        """, formData);

    return formData;
  }

  @Override
  public ChapterFormData store(ChapterFormData formData) {

    SQL.update(
      """
        update chapter set name = :chapterName where chapter_nr = :chapterNr
        """, formData);

    return formData;
  }
}
