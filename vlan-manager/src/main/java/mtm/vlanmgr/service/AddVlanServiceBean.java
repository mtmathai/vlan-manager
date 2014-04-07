package mtm.vlanmgr.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import mtm.vlanmgr.Vlan;
import mtm.vlanmgr.VlanFactory;
import mtm.vlanmgr.repository.VlanRepository;

@ApplicationScoped
public class AddVlanServiceBean implements AddVlanService {

  @Inject
  protected VlanFactory vlanFactory;
  
  @Inject
  protected VlanRepository vlanRepository;
  
  @Override
  public Vlan newVlan() {
    return vlanFactory.newVlan();
  }

  @Override
  @Transactional
  public void saveVlan(Vlan vlan) throws AddVlanException {
    vlanRepository.add(vlan);
  }

}
