package mtm.vlanmgr.repository;

import java.util.List;

import mtm.vlanmgr.Vlan;

public interface VlanRepository {

  void add(Vlan vlan) throws RepositoryException;

  List<Vlan> findAll();
  
}
