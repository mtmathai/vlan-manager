package mtm.vlanmgr.facelets;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mtm.vlanmgr.service.EditVlanException;
import mtm.vlanmgr.service.EditVlanService;
import mtm.vlanmgr.service.VlanEditor;

@Named
@SessionScoped

public class EditVlanBean implements Serializable {
	
	private static final long serialVersionUID = 1543893633861762281L;
	
	@Inject
	protected EditVlanService editVlanService;
	
	private Long id;
	private VlanEditor vlanEditor;
	
	public String createEditor() {
	  if (id == null) {
	    return "failure";
	  }
	  
	  vlanEditor = editVlanService.editVlan(id);
	  return null;
	}
	
	public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public VlanEditor getVlanEditor() {
    return vlanEditor;
  }

  public String save() {
    try {
      editVlanService.saveVlan(vlanEditor);
      return "success";
    }
    catch (EditVlanException ex) {
      return null;
    }
	}
	
}
