package ch.nteinno.frwdeluxe.frwdeluxe.server.chapter;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter.ChapterTableTablePageData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter.IChapterTableService;
import org.eclipse.scout.rt.platform.holders.NVPair;
import org.eclipse.scout.rt.server.jdbc.SQL;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class ChapterTableService implements IChapterTableService {
  @Override
  public ChapterTableTablePageData getChapterTableTableData(SearchFilter filter) {
    ChapterTableTablePageData pageData = new ChapterTableTablePageData();

    String statement = """
      select c.chapter_nr,
                   c.name,
                   count(booking_fact_nr)
            from chapter c
                     left join booking_fact bf on c.chapter_nr = bf.chapter_nr
            group by c.chapter_nr, c.name
            into  :{page.id},
                  :{page.chapterName},
                  :{page.bookingFactCount}
      """;

    SQL.selectInto(statement, new NVPair("page", pageData));

    return pageData;
  }
}
