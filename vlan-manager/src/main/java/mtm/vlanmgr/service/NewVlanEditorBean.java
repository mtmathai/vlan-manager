package mtm.vlanmgr.service;

import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;

@Dependent
public class NewVlanEditorBean extends AbstractVlanEditorBean {

  @Override
  @Transactional(Transactional.TxType.MANDATORY)
  public void save() throws EditorException {
    vlanRepository.add(vlan);
  }

}
