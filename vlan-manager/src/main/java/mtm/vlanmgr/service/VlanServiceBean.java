package mtm.vlanmgr.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import mtm.vlanmgr.Vlan;
import mtm.vlanmgr.repository.VlanRepository;

@ApplicationScoped
public class VlanServiceBean implements VlanService {

  @Inject
  protected VlanRepository vlanRepository;
  
  @Override
  @Transactional
  public List<VlanDetail> findAllVlans() {
    List<Vlan> vlans = vlanRepository.findAll(); 
    List<VlanDetail> details = new ArrayList<>(vlans.size());
    for (Vlan vlan : vlans) {
      details.add(new VlanDetailWrapper(vlan));
    }
    return details;
  }

}
