package ch.nteinno.frwdeluxe.frwdeluxe.server;

import org.eclipse.scout.rt.platform.nls.NlsLocale;
import org.eclipse.scout.rt.server.AbstractServerSession;
import org.eclipse.scout.rt.server.session.ServerSessionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * @author nsd
 */
public class ServerSession extends AbstractServerSession {

  private static final long serialVersionUID = 1L;
  private static final Logger LOG = LoggerFactory.getLogger(ServerSession.class);

  public final Locale DEFAULT_LOCALE = Locale.forLanguageTag("de-ch");

  public ServerSession() {
    super(true);
    NlsLocale.set(DEFAULT_LOCALE);
  }

  /**
   * @return The {@link ServerSession} which is associated with the current thread, or {@code null} if not found.
   */
  public static ServerSession get() {
    return ServerSessionProvider.currentSession(ServerSession.class);
  }

  @Override
  protected void execLoadSession() {
    LOG.info("created a new session for {}", getUserId());
  }
}
