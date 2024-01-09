package ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

@TunnelToServer
public interface IBookingFactService extends IService {
  BookingFactFormData prepareCreate(BookingFactFormData formData);

  BookingFactFormData create(BookingFactFormData formData);

  BookingFactFormData load(BookingFactFormData formData);

  BookingFactFormData store(BookingFactFormData formData);
}
