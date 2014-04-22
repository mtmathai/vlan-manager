package mtm.vlanmgr.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang.Validate;

@ApplicationScoped
public class EditVlanServiceBean implements EditVlanService {

  @Inject
  protected VlanEditorFactory editorFactory;
  
  @Override
  public VlanEditor editVlan(Long id) {
    return editorFactory.newEditor(id);
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRED)
  public void saveVlan(VlanEditor editor) throws EditVlanException {
    Validate.isTrue(editor instanceof SaveableVlanEditor);
    try {
      ((SaveableVlanEditor) editor).save();
    }
    catch (EditorException ex) {
      throw new EditVlanException();
    }
  }

}
