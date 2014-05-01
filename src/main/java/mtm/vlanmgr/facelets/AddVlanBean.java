package mtm.vlanmgr.facelets;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
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
  static final String CANCEL_OUTCOME = "cancel";
  
  @Inject
  protected AddVlanService addVlanService;
  
  @Inject
  protected Errors errors;
  
  @Inject
  protected Conversation conversation;
  
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
    conversation.begin();
  }
  
  public String save() {
    try {
      addVlanService.saveVlan(vlan, errors);
      conversation.end();
      return SUCCESS_OUTCOME;
    }
    catch (VlanException ex) {
      return null;
    }
  }
  
  public String cancel() {
    conversation.end();
    return CANCEL_OUTCOME;
  }
  
}
