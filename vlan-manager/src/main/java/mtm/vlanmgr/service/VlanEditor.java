package mtm.vlanmgr.service;


public interface VlanEditor {

  Integer getVlanId();
  
  void setVlanId(Integer vlanId);
  
  String getName();
  
  void setName(String name);
  
  String getNote();
  
  void setNote(String note);
  
}
