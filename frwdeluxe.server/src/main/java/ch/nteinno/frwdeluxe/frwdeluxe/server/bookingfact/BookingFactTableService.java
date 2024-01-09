package ch.nteinno.frwdeluxe.frwdeluxe.server.bookingfact;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.BookingFactSearchFormData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.BookingFactTableTablePageData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.IBookingFactTableService;
import org.eclipse.scout.rt.platform.holders.NVPair;
import org.eclipse.scout.rt.server.jdbc.SQL;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class BookingFactTableService implements IBookingFactTableService {
  @Override
  public BookingFactTableTablePageData getBookingFactTableTableData(SearchFilter filter) {
    BookingFactTableTablePageData pageData = new BookingFactTableTablePageData();
    BookingFactSearchFormData searchFormData = ((BookingFactSearchFormData) filter.getFormData());

    String statement = """
         select bf.booking_fact_nr,
               bf.booking_fact,
               coalesce(r.reveal_should, false),
               bf.should,
               coalesce(r.reveal_have, false),
               bf.have
          from booking_fact bf
          left join reveal r on bf.booking_fact_nr = r.booking_fact_nr
                           and r.user_nr = 1
         where chapter_nr = %s
         into :{page.key},
              :{page.bookingFact},
              :{page.revealedShould},
              :{page.should},
              :{page.revealedHave},
              :{page.have}
      """.formatted(searchFormData.getChapterNr().getValue());

    SQL.selectInto(statement, new NVPair("page", pageData));

    return pageData;
  }
}
