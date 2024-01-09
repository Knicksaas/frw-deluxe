package ch.nteinno.frwdeluxe.frwdeluxe.client.quiz;

import ch.nteinno.frwdeluxe.frwdeluxe.client.quiz.QuizTableTablePage.Table;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.Icons;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.quiz.IQuizTableService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.quiz.QuizTableTablePageData;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.CollectionUtility;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

import java.util.Set;

@Data(QuizTableTablePageData.class)
@ClassId("7293c1da-71d5-4ad6-8ef9-1125db466681")
public class QuizTableTablePage extends AbstractPageWithTable<Table> {
  @Override
  protected boolean getConfiguredLeaf() {
    return true;
  }

  @Override
  protected void execLoadData(SearchFilter filter) {
    importPageData(BEANS.get(IQuizTableService.class).getQuizTableTableData(filter));
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Quizzes");
  }

  @ClassId("64ac658a-3fd2-4606-b837-f96a7fe14423")
  public class Table extends AbstractTable {


    @Order(1000)
    @ClassId("97cc1b04-6f7f-4e6e-b6eb-06b19ad934dc")
    public class StartNewQuizMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return TEXTS.get("StartNewQuiz");
      }

      @Override
      protected Set<? extends IMenuType> getConfiguredMenuTypes() {
        return CollectionUtility.hashSet(TableMenuType.EmptySpace);
      }

      @Override
      protected String getConfiguredIconId() {
        return Icons.PlusBold;
      }

      @Override
      protected void execAction() {

      }
    }
  }
}
