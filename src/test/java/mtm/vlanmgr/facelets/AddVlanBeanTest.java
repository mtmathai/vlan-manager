package mtm.vlanmgr.facelets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.jmock.Expectations.returnValue;
import static org.jmock.Expectations.throwException;
import mtm.vlanmgr.service.AddVlanService;
import mtm.vlanmgr.service.Errors;
import mtm.vlanmgr.service.VlanEditor;
import mtm.vlanmgr.service.VlanException;

import org.jmock.Expectations;
import org.jmock.api.Action;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AddVlanBeanTest {
  
  @Rule
  public final JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  private AddVlanService addVlanService;
  
  @Mock
  private Errors errors;
  
  @Mock
  private VlanEditor editor;

  private AddVlanBean bean = new AddVlanBean();
  
  @Before
  public void setUp() throws Exception {
    bean.addVlanService = addVlanService;
    bean.errors = errors;
  }
  
  @Test
  public void testInit() throws Exception {
    context.checking(new Expectations() { {
      oneOf(addVlanService).createEditor();
      will(returnValue(editor));
    } });
    
    bean.init();
    assertThat(bean.getVlan(), is(sameInstance((Object) editor)));
  }

  @Test
  public void testSave() throws Exception {
    context.checking(saveVlanExpectations(returnValue(null)));
    
    bean.setVlan(editor);
    assertThat(bean.save(), is(equalTo(AddVlanBean.SUCCESS_OUTCOME)));
  }
  
  @Test
  public void testSaveWhenVlanException() throws Exception {
    context.checking(saveVlanExpectations(throwException(new VlanException())));

    bean.setVlan(editor);
    assertThat(bean.save(), is(nullValue()));
  }

  private Expectations saveVlanExpectations(final Action outcome) 
      throws VlanException {
    return new Expectations() { { 
      oneOf(addVlanService).saveVlan(with(same(editor)), 
          with(same(errors)));
      will(outcome);
    } };
  }

}
