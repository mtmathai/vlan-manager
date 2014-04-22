package mtm.vlanmgr.facelets;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mtm.vlanmgr.service.AddVlanException;
import mtm.vlanmgr.service.AddVlanService;
import mtm.vlanmgr.service.VlanEditor;

@Named
@RequestScoped

public class AddVlanBean implements Serializable {
	
	private static final long serialVersionUID = 1543893633861762281L;
	
	@Inject
	protected AddVlanService addVlanService;
	
	private VlanEditor vlanEditor;
	
	@PostConstruct
	public void init() {
	  vlanEditor = addVlanService.newVlan();
	}
	
	public VlanEditor getVlanEditor() {
    return vlanEditor;
  }

  public String save() {
    try {
      addVlanService.saveVlan(vlanEditor);
      return "success";
    }
    catch (AddVlanException ex) {
      return null;
    }
	}
	
}
