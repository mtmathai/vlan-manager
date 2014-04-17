package mtm.vlanmgr.service;

import mtm.vlanmgr.Vlan;

import org.apache.commons.lang.Validate;

public class VlanDetailWrapper implements VlanDetail {

  private final Vlan vlan;
  
  public VlanDetailWrapper(Vlan vlan) {
    Validate.notNull(vlan);
    this.vlan = vlan;
  }

  @Override
  public Integer getVlanId() {
    return vlan.getVlanId();
  }

  @Override
  public String getName() {
    return vlan.getName();
  }

  @Override
  public String getNote() {
    return vlan.getNote();
  }

}
