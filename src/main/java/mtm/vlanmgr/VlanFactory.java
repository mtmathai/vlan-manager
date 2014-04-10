package mtm.vlanmgr;


public interface VlanFactory {
	
	/** 
	 * Creates a new transient instance of a {@link Vlan} 
	 * @return new vlan object
	*/
	Vlan newVlan(); // Factory method which is used instead of Vlan vlan = new Vlan (). 

}
