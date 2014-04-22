package mtm.vlanmgr;

public interface Vlan {

  Long getId();
  
  Integer getVlanId();
  
  void setVlanId(Integer vlanId);
  
  String getName();
  
  void setName(String name);
  
  String getNote();
  
  void setNote(String note);
  
}
