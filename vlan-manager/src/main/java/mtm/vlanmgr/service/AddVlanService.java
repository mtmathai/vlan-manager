package mtm.vlanmgr.service;

import mtm.vlanmgr.Vlan;

public interface AddVlanService {

  Vlan newVlan();
  
  void saveVlan(Vlan vlan) throws AddVlanException;
  
}
