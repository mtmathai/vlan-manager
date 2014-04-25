package mtm.vlanmgr.facelets;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mtm.vlanmgr.service.AddVlanService;
import mtm.vlanmgr.service.Errors;
import mtm.vlanmgr.service.VlanEditor;

@Named
@ConversationScoped
public class AddVlanBean {

  @Inject
  protected AddVlanService addVlanService;
  
  @Inject
  protected Errors errors;
  
  private VlanEditor vlan;
  
  public VlanEditor getVlan() {
    return vlan;
  }

  public String save() {
    // TODO
    return null;
  }
  
}
