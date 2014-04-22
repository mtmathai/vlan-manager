package mtm.vlanmgr.service;

import javax.enterprise.context.Dependent;

@Dependent
@ExistingEntity
public class ExistingVlanEditorBean extends AbstractVlanEditorBean {

  @Override
  public void save() throws EditorException {
    vlan = vlanRepository.update(vlan);
  }

}
