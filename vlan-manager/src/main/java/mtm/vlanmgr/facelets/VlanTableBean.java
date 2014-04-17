package mtm.vlanmgr.facelets;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mtm.vlanmgr.service.VlanDetail;
import mtm.vlanmgr.service.VlanService;

@Named
@RequestScoped

public class VlanTableBean {

  @Inject
  protected VlanService vlanService;
  
  private List<VlanDetail> vlans;
  
  @PostConstruct
  public void init() {
    vlans = vlanService.findAllVlans();
  }
  
  public List<VlanDetail> getVlans() {
    return vlans;
  }
  
}
