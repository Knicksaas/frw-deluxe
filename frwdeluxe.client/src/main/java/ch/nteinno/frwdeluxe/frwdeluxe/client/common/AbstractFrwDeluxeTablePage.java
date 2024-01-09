package ch.nteinno.frwdeluxe.frwdeluxe.client.common;

import org.eclipse.scout.rt.client.ui.basic.table.ITable;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.client.ui.form.FormEvent;
import org.eclipse.scout.rt.client.ui.form.FormListener;

public abstract class AbstractFrwDeluxeTablePage<T extends ITable> extends AbstractPageWithTable<T> implements FormListener {

  @Override
  public void formChanged(FormEvent e) {
    if (FormEvent.TYPE_CLOSED == e.getType() && e.getForm().isFormStored()) {
      reloadPage();
    }
  }
}
