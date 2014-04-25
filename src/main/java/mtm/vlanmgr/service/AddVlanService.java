package mtm.vlanmgr.service;

public interface AddVlanService {

  /**
   * Creates an editor for a new VLAN.
   * @return VLAN editor
   */
  VlanEditor createEditor();

  /**
   * Saves the contents of the given editor as a new VLAN.
   * @param editor the subject editor
   * @param errors a collection of error messages that will be updated
   *    if an error occurs
   * @throws VlanException if a recoverable error occurs
   */
  void saveVlan(VlanEditor editor, Errors errors) throws VlanException;

}
