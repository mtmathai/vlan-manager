package mtm.vlanmgr.service;

import javax.inject.Inject;

import mtm.vlanmgr.Vlan;
import mtm.vlanmgr.VlanFactory;

public class AddVlanServiceBean implements AddVlanService {
	
	@Inject
	protected VlanFactory vlanFactory;

	@Override
	public Vlan newVlan() {
		return vlanFactory.newVlan();
	}

	@Override
	public void saveVlan(Vlan vlan) throws AddVlanException {
		System.out.println("saved VLAN " + vlan.getVlanId());
	}

}
