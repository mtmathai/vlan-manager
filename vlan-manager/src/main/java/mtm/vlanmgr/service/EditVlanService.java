package mtm.vlanmgr.service;

public interface EditVlanService {
  
  /**
   * Creates an editor for an existing VLAN
   * @param id the unique identifier of the VLAN to edit
   * @return editor
   */
  VlanEditor editVlan(Long id);

  /**
   * Saves the contents of the editor, making the changes to the underlying
   * VLAN persistent.
   * @param editor the editor whose contents are to be saved
   * @throws EditVlanException if a recoverable error occurs
   */
  void saveVlan(VlanEditor editor) throws EditVlanException;
  
}
