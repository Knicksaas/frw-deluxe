package ch.nteinno.frwdeluxe.frwdeluxe.server.quiz;

import ch.nteinno.frwdeluxe.frwdeluxe.shared.quiz.IQuizTableService;
import ch.nteinno.frwdeluxe.frwdeluxe.shared.quiz.QuizTableTablePageData;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class QuizTableService implements IQuizTableService {
  @Override
  public QuizTableTablePageData getQuizTableTableData(SearchFilter filter) {
    QuizTableTablePageData pageData = new QuizTableTablePageData();
// TODO [nsd] fill pageData.
    return pageData;
  }
}
