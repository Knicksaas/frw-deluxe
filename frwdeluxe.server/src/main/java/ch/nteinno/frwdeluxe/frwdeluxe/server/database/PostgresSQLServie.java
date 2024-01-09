package ch.nteinno.frwdeluxe.frwdeluxe.server.database;

import org.eclipse.scout.rt.server.jdbc.postgresql.AbstractPostgreSqlService;

public class PostgresSQLServie extends AbstractPostgreSqlService {

  @Override
  protected String getConfiguredJdbcMappingName() {
    return "jdbc:postgresql://localhost:5432/frwdeluxe";
  }

  @Override
  protected String getConfiguredUsername() {
    return "postgres";
  }

  @Override
  protected String getConfiguredPassword() {
    return "postgres";
  }
}
