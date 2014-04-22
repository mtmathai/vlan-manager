package mtm.vlanmgr.service;

public interface AddVlanService {
  
  /**
   * Creates an editor for a new VLAN.
   * @return editor
   */
  VlanEditor newVlan();

  /**
   * Saves the contents of the editor, making a new persistent VLAN.
   * @param editor the editor whose contents are to be saved
   * @throws AddVlanException if a recoverable error occurs
   */
  void saveVlan(VlanEditor editor) throws AddVlanException;
  
}
