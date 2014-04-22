package mtm.vlanmgr.service;

import mtm.vlanmgr.Vlan;

public interface DelegatingVlanEditor extends SaveableVlanEditor {

  Vlan getDelegate();
  
  void setDelegate(Vlan delegate);
  
}
