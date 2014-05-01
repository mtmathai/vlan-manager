package mtm.vlanmgr.service;

public interface SaveableVlanEditor extends VlanEditor {
  
  void save(Errors errors) throws VlanException;
  
}
