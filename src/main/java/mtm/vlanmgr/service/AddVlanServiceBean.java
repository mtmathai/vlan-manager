package mtm.vlanmgr.service;

import javax.inject.Inject;

public class AddVlanServiceBean implements AddVlanService {

  @Inject
  protected VlanEditorFactory editorFactory;
  
  @Override
  public VlanEditor createEditor() {
    return null;
  }

  @Override
  public void saveVlan(VlanEditor editor, Errors errors) throws VlanException {
  }

}
