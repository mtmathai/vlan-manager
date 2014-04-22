package mtm.vlanmgr.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import mtm.vlanmgr.VlanFactory;
import mtm.vlanmgr.repository.VlanRepository;

@ApplicationScoped
public class VlanEditorFactoryBean implements VlanEditorFactory {

  @Inject @NewEntity
  protected Instance<DelegatingVlanEditor> newEditors;
  
  @Inject @ExistingEntity
  protected Instance<DelegatingVlanEditor> existingEditors;
  
  @Inject
  protected VlanFactory vlanFactory;
  
  @Inject 
  protected VlanRepository vlanRepository;
  
  @Override
  public SaveableVlanEditor newEditor() {
    DelegatingVlanEditor editor = newEditors.get();
    editor.setDelegate(vlanFactory.newVlan());
    return editor;
  }

  @Override
  public SaveableVlanEditor newEditor(Long id) {
    DelegatingVlanEditor editor = existingEditors.get();
    editor.setDelegate(vlanRepository.findById(id));
    return editor;
  }

}
