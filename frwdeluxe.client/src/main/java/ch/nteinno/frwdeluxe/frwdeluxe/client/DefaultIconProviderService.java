package ch.nteinno.frwdeluxe.frwdeluxe.client;

import org.eclipse.scout.rt.client.services.common.icon.AbstractIconProviderService;

import java.net.URL;

/**
 * @author nsd
 */
public class DefaultIconProviderService extends AbstractIconProviderService {
  @Override
  protected URL findResource(String relativePath) {
    return ResourceBase.class.getResource("icons/" + relativePath);
  }
}
