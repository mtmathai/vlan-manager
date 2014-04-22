package mtm.vlanmgr.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang.Validate;

@ApplicationScoped
public class AddVlanServiceBean implements AddVlanService {

  @Inject
  protected VlanEditorFactory editorFactory;
  
  @Override
  public VlanEditor newVlan() {
    return editorFactory.newEditor();
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRED)
  public void saveVlan(VlanEditor editor) throws AddVlanException {
    Validate.isTrue(editor instanceof SaveableVlanEditor);
    try {
      ((SaveableVlanEditor) editor).save();
    }
    catch (EditorException ex) {
      throw new AddVlanException();
    }
  }

}
