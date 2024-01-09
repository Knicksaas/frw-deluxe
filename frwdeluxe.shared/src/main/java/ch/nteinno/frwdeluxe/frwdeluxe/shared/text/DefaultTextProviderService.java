package ch.nteinno.frwdeluxe.frwdeluxe.shared.text;

import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.AbstractDynamicNlsTextProviderService;

/**
 * @author nsd
 */
@Order(-2000)
public class DefaultTextProviderService extends AbstractDynamicNlsTextProviderService {
  @Override
  public String getDynamicNlsBaseName() {
    return "ch.nteinno.frwdeluxe.frwdeluxe.shared.texts.Texts";
  }
}
