package mtm.vlanmgr.repository;

import java.util.List;

import mtm.vlanmgr.Vlan;

public interface VlanRepository {

  void add(Vlan vlan) throws RepositoryException;

  Vlan update(Vlan vlan) throws RepositoryException;
  
  Vlan findById(Long id);
  
  List<Vlan> findAll();
  
}
