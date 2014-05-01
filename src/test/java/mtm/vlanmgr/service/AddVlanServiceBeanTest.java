package mtm.vlanmgr.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AddVlanServiceBeanTest {

  @Rule
  public final JUnitRuleMockery context = new JUnitRuleMockery();
  
  @Mock
  private VlanEditorFactory editorFactory;
  
  @Mock
  private SaveableVlanEditor editor;
  
  @Mock
  private Errors errors;
  
  private AddVlanServiceBean service = new AddVlanServiceBean();
 
  @Before
  public void setUp() throws Exception {
    service.editorFactory = editorFactory;
  }
  
  @Test
  public void testCreateEditor() throws Exception {
    context.checking(new Expectations() { { 
      oneOf(editorFactory).newEditor();
      will(returnValue(editor));
    } });
    
    assertThat(service.createEditor(), is(sameInstance((Object) editor)));
  }
  
  @Test
  public void testSaveVlan() throws Exception {
    context.checking(new Expectations() { { 
      oneOf(editor).save(errors);
    } });
    service.saveVlan(editor, errors);
  }
  
}
