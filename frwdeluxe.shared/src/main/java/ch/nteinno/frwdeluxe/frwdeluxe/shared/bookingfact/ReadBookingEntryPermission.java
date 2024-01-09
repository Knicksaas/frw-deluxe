package ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact;

import org.eclipse.scout.rt.security.AbstractPermission;

public class ReadBookingEntryPermission extends AbstractPermission {
  private static final long serialVersionUID = 1L;

  public ReadBookingEntryPermission() {
    super("ReadBookingEntryPermission");
  }
}
