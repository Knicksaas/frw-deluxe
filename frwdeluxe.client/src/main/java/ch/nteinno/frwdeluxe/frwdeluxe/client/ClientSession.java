package ch.nteinno.frwdeluxe.frwdeluxe.client;

import org.eclipse.scout.rt.client.AbstractClientSession;
import org.eclipse.scout.rt.client.IClientSession;
import org.eclipse.scout.rt.client.session.ClientSessionProvider;
import org.eclipse.scout.rt.platform.nls.NlsLocale;
import org.eclipse.scout.rt.shared.services.common.code.CODES;

import java.util.Locale;

/**
 * @author nsd
 */
public class ClientSession extends AbstractClientSession {

  public final Locale DEFAULT_LOCALE = Locale.forLanguageTag("de-ch");

  public ClientSession() {
    super(true);
    setLocale(DEFAULT_LOCALE);
  }

  /**
   * @return The {@link IClientSession} which is associated with the current thread, or {@code null} if not found.
   */
  public static ClientSession get() {
    return ClientSessionProvider.currentSession(ClientSession.class);
  }

  @Override
  protected void execLoadSession() {
    CODES.getAllCodeTypes("ch.nteinno.frwdeluxe.frwdeluxe.shared");

    // NLS Locale
    NlsLocale.set(DEFAULT_LOCALE);

    setDesktop(new Desktop());
  }
}
