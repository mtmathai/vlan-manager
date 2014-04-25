package mtm.vlanmgr.facelets;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mtm.vlanmgr.service.AddVlanService;
import mtm.vlanmgr.service.Errors;
import mtm.vlanmgr.service.VlanEditor;
import mtm.vlanmgr.service.VlanException;

@Named
@ConversationScoped
public class AddVlanBean {

  static final String SUCCESS_OUTCOME = "success";
  
  @Inject
  protected AddVlanService addVlanService;
  
  @Inject
  protected Errors errors;
  
  private VlanEditor vlan;
  
  public VlanEditor getVlan() {
    return vlan;
  }

  void setVlan(VlanEditor vlan) {
    this.vlan = vlan;
  }
  
  @PostConstruct
  public void init() {
    vlan = addVlanService.createEditor();
  }
  
  public String save() {
    try {
      addVlanService.saveVlan(vlan, errors);
      return SUCCESS_OUTCOME;
    }
    catch (VlanException ex) {
      return null;
    }
  }
  
}
