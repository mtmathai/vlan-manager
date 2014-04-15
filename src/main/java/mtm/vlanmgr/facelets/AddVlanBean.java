package mtm.vlanmgr.facelets;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mtm.vlanmgr.Vlan;
import mtm.vlanmgr.service.AddVlanException;
import mtm.vlanmgr.service.AddVlanService;

@Named
@RequestScoped

public class AddVlanBean implements Serializable {
	
	private static final long serialVersionUID = 1543893633861762281L;
	
	/* The injected service and post constructed initialization have the same effect as instantiation of a concrete vlan class 
	 * but uses good design principle that allows for the design of the vlan to be open
	 */
	
	@Inject
	protected AddVlanService addVlanService;
	
	private Vlan vlan;
	
	@PostConstruct
	public void init() {
		vlan = addVlanService.newVlan();
	}
	
	/* Needed for the Web form */
	public Vlan getVlan() {
		return vlan;
	}
	
	public String save() {
		//System.out.println("Saved VLAN "+vlan.getVlanId());
		try {
			addVlanService.saveVlan(vlan);
			return "success";
		} catch (AddVlanException e) {
			return null;
		}
		
	}
	
}
