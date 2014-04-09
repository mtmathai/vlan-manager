package mtm.vlanmgr;


public interface VlanFactory {
	
	/* Creates a new transient instance of a vlan */
	Vlan newVlan(); // Factory method which is used instead of Vlan vlan = new Vlan (). 

}
