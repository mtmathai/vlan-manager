package mtm.vlanmgr.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import mtm.vlanmgr.VlanFactory;

@ApplicationScoped
public class VlanEditorFactoryBean implements VlanEditorFactory {

  @Inject
  protected Instance<DelegatingVlanEditor> newEditors;
  
  @Inject
  protected VlanFactory vlanFactory;
  
  @Override
  public SaveableVlanEditor newEditor() {
    DelegatingVlanEditor editor = newEditors.get();
    editor.setDelegate(vlanFactory.newVlan());
    return editor;
  }

  @Override
  public SaveableVlanEditor newEditor(Long id) {
    throw new UnsupportedOperationException();
  }

}
