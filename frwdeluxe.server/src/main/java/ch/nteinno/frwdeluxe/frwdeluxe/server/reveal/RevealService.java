package ch.nteinno.frwdeluxe.frwdeluxe.server.reveal;

import ch.nteinno.frwdeluxe.frwdeluxe.server.ServerSession;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.reveal.IRevealService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.user.IUserService;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.holders.NVPair;
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
    Long userNr = BEANS.get(IUserService.class).getUserNumberByUsername(ServerSession.get().getUserId());

    NVPair userNrPair = new NVPair("userNr", userNr);

    int updatedRows = SQL.update(
      """
        UPDATE reveal SET
          reveal_should = %b,
          reveal_have   = %b
        WHERE booking_fact_nr = %s
          and user_nr = :userNr;
        """.formatted(should, have, bookingFactNr),
      userNrPair
    );

    if (updatedRows > 0) {
      // New change was upated
      return;
    }

    SQL.insert(
      """
        INSERT INTO reveal (booking_fact_nr, reveal_should, reveal_have, user_nr)
        VALUES (%s, %b, %b, %s);
        """.formatted(bookingFactNr, should, have, userNr)
    );
  }
}
