package mtm.vlanmgr.domain;

import javax.enterprise.context.ApplicationScoped;

import mtm.vlanmgr.Vlan;
import mtm.vlanmgr.VlanFactory;

@ApplicationScoped
public class VlanEntityFactory implements VlanFactory {

  @Override
  public Vlan newVlan() {
    return new VlanEntity();
  }

}
