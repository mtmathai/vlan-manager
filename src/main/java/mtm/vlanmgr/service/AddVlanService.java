package mtm.vlanmgr.service;

import mtm.vlanmgr.Vlan;

public interface AddVlanService {
	
	/* Creates a new transient instance of a vlan */
	Vlan newVlan(); // Factory method which is used instead of Vlan vlan = new Vlan (). 
	
	/* Saves a transient Vlan, making it persistent */
	void saveVlan (Vlan vlan) throws AddVlanException;
	

}
