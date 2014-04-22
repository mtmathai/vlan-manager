package mtm.vlanmgr.service;

public interface SaveableVlanEditor extends VlanEditor {

  void save() throws EditorException;
  
}
