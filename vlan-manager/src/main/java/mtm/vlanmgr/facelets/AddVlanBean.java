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
	
	@Inject
	protected AddVlanService addVlanService;
	
	private Vlan vlan;
	
	@PostConstruct
	public void init() {
	  vlan = addVlanService.newVlan();
	}
	
	public Vlan getVlan() {
    return vlan;
  }

  public String save() {
    try {
      addVlanService.saveVlan(vlan);
      return "success";
    }
    catch (AddVlanException ex) {
      return null;
    }
	}
	
}
