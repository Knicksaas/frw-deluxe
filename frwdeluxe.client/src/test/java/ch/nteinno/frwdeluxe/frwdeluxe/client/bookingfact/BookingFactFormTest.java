package ch.nteinno.frwdeluxe.frwdeluxe.client.bookingfact;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.BookingFactFormData;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.bookingfact.IBookingFactService;
import org.eclipse.scout.rt.client.testenvironment.TestEnvironmentClientSession;
import org.eclipse.scout.rt.testing.client.runner.ClientTestRunner;
import org.eclipse.scout.rt.testing.client.runner.RunWithClientSession;
import org.eclipse.scout.rt.testing.platform.mock.BeanMock;
import org.eclipse.scout.rt.testing.platform.runner.RunWithSubject;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

@RunWithSubject("anonymous")
@RunWith(ClientTestRunner.class)
@RunWithClientSession(TestEnvironmentClientSession.class)
public class BookingFactFormTest {
  @BeanMock
  private IBookingFactService m_mockSvc;
// TODO [nsd] add test cases

  @Before
  public void setup() {
    BookingFactFormData answer = new BookingFactFormData();
    Mockito.when(m_mockSvc.prepareCreate(ArgumentMatchers.any())).thenReturn(answer);
    Mockito.when(m_mockSvc.create(ArgumentMatchers.any())).thenReturn(answer);
    Mockito.when(m_mockSvc.load(ArgumentMatchers.any())).thenReturn(answer);
    Mockito.when(m_mockSvc.store(ArgumentMatchers.any())).thenReturn(answer);
  }
}
