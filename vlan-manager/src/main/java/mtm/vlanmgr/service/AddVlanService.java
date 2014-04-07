package mtm.vlanmgr.service;

import mtm.vlanmgr.Vlan;

public interface AddVlanService {
  
  /**
   * Creates a new transient instance of {@link Vlan}.
   * @return new vlan object
   */
  Vlan newVlan();

  /**
   * Saves a transient Vlan, making it persistent.
   * @param vlan the vlan to save
   * @throws AddVlanException if a recoverable error occurs
   */
  void saveVlan(Vlan vlan) throws AddVlanException;
  
}
