package mtm.vlanmgr.repository;

import mtm.vlanmgr.Vlan;

public interface VlanRepository {

  void add(Vlan vlan) throws RepositoryException;

}
