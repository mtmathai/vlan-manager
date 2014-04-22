package mtm.vlanmgr.service;

public interface VlanEditorFactory {
 
  /**
   * Creates an editor for a new VLAN.
   * @return editor object
   */
  SaveableVlanEditor newEditor();
  
  /**
   * Creates an editor for an existing VLAN.
   * @param id the unique identifier of the VLAN to edit
   * @return editor object
   */
  SaveableVlanEditor newEditor(Long id);
  
}
