package ch.nteinno.frwdeluxe.frwdeluxe.shared.reveal;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

import java.util.List;

@TunnelToServer
public interface IRevealService extends IService {

  void revealBookingFact(Long bookingFactNr, boolean should, boolean have);

  void unrevealBookingFacts(List<Long> bookingFactNrs);

}
