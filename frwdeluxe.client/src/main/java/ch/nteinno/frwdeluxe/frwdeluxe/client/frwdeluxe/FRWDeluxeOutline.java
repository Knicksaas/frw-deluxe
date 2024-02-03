package ch.nteinno.frwdeluxe.frwdeluxe.client.frwdeluxe;

import ch.nteinno.frwdeluxe.frwdeluxe.client.chapter.ChapterTablePage;
import ch.nteinno.frwdeluxe.frwdeluxe.client.quiz.QuizTableTablePage;
import ch.nteinno.frwdeluxe.frwdeluxe.client.user.UserTableTablePage;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.Icons;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.TEXTS;

import java.util.List;

/**
 * @author nsd
 */
@Order(1000)
public class FRWDeluxeOutline extends AbstractOutline {

  @Override
  protected void execCreateChildPages(List<IPage<?>> pageList) {
    super.execCreateChildPages(pageList);
    pageList.add(new ChapterTablePage());
    pageList.add(new QuizTableTablePage());
    pageList.add(new UserTableTablePage());
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("FRWDeluxe");
  }

  @Override
  protected String getConfiguredIconId() {
    return Icons.Pencil;
  }
}
