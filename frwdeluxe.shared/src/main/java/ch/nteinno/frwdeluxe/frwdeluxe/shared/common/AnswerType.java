package ch.nteinno.frwdeluxe.frwdeluxe.shared.common;

public enum AnswerType {
  SHOULD("SHOULD"),
  HAVE("HAVE");

  private final String m_value;

  private AnswerType(String value) {
    m_value = value;
  }

  public String getValue() {
    return m_value;
  }
}
