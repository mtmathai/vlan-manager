package mtm.vlanmgr.service;

import mtm.vlanmgr.Vlan;

public interface AddVlanService {
	
	Vlan newVlan();
	
	/* Saves a transient Vlan, making it persistent */
	void saveVlan (Vlan vlan) throws AddVlanException;
}
