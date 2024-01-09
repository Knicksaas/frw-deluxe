package ch.nteinno.frwdeluxe.frwdeluxe.server.bookingfact;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.BookingFactFormData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.IBookingFactService;
import org.eclipse.scout.rt.server.jdbc.SQL;

public class BookingFactService implements IBookingFactService {
  @Override
  public BookingFactFormData prepareCreate(BookingFactFormData formData) {
    formData.getChapter().setValue(formData.getChapterNr());
    return formData;
  }

  @Override
  public BookingFactFormData create(BookingFactFormData formData) {
    SQL.insert(
      """
        INSERT INTO booking_fact (chapter_nr, booking_fact, should, have, status_uid)
        VALUES (:chapterNr, :bookingFact, :should, :have, 101);
        """, formData);

    return formData;
  }

  @Override
  public BookingFactFormData load(BookingFactFormData formData) {
    SQL.selectInto(
      """
          select chapter_nr, booking_fact, should, have from booking_fact
          into :chapter, :bookingFact, :should, :have
          where booking_fact_nr = :bookingFactNr
        """, formData);

    return formData;
  }

  @Override
  public BookingFactFormData store(BookingFactFormData formData) {
    SQL.update(
      """
        update booking_fact set
        chapter_nr = :chapter,
        booking_fact = :bookingFact,
        should = :should,
        have = :have
        where booking_fact_nr = :bookingFactNr
        """, formData);

    return formData;
  }
}
