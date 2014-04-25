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

  @Inject
  protected AddVlanService addVlanService;
  
  @Inject
  protected Errors errors;
  
  private VlanEditor vlan;

  @PostConstruct
  public void init() {
    vlan = addVlanService.createEditor();
  }
  
  public VlanEditor getVlan() {
    return vlan;
  }

  public String save() {
    try {
      addVlanService.saveVlan(vlan, errors);
      return "success";
    }
    catch (VlanException ex) {
      return null;
    }
  }
  
}
