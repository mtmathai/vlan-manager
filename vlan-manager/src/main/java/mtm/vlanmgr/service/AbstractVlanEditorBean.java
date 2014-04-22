package mtm.vlanmgr.service;

import javax.inject.Inject;

import mtm.vlanmgr.Vlan;
import mtm.vlanmgr.repository.VlanRepository;


public abstract class AbstractVlanEditorBean implements DelegatingVlanEditor {

  @Inject
  protected VlanRepository vlanRepository;
  
  protected Vlan vlan;

  @Override
  public Integer getVlanId() {
    return vlan.getVlanId();
  }

  @Override
  public void setVlanId(Integer vlanId) {
    vlan.setVlanId(vlanId);
  }

  @Override
  public String getName() {
    return vlan.getName();
  }

  @Override
  public void setName(String name) {
    vlan.setName(name);
  }

  @Override
  public String getNote() {
    return vlan.getNote();
  }

  @Override
  public void setNote(String note) {
    vlan.setNote(note);
  }

  @Override
  public Vlan getDelegate() {
    return vlan;
  }

  @Override
  public void setDelegate(Vlan delegate) {
    this.vlan = delegate;
  }

}
