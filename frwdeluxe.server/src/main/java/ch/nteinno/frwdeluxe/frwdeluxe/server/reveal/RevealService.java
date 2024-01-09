package ch.nteinno.frwdeluxe.frwdeluxe.server.reveal;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.reveal.IRevealService;
import org.eclipse.scout.rt.server.jdbc.SQL;

import java.util.List;

public class RevealService implements IRevealService {

  @Override
  public void revealBookingFact(Long bookingFactNr, boolean should, boolean have) {
    changeRevealBookingFact(bookingFactNr, should, have);
  }

  @Override
  public void unrevealBookingFacts(List<Long> bookingFactNrs) {
    for (Long bookingFactNr : bookingFactNrs) {
      changeRevealBookingFact(bookingFactNr, false, false);
    }
  }

  private void changeRevealBookingFact(Long bookingFactNr, boolean should, boolean have) {
    int updatedRows = SQL.update(
      """
        UPDATE reveal SET
          reveal_should = %b,
          reveal_have   = %b
        WHERE booking_fact_nr = %s
          and user_nr = 1;
        """.formatted(should, have, bookingFactNr)
    );

    if (updatedRows > 0) {
      // New change was upated
      return;
    }

    SQL.insert(
      """
        INSERT INTO reveal (booking_fact_nr, reveal_should, reveal_have, user_nr)
        VALUES (%s, %b, %b, 1);
        """.formatted(bookingFactNr, should, have)
    );
  }
}
