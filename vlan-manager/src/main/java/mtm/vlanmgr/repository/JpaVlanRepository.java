package mtm.vlanmgr.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import mtm.vlanmgr.Vlan;

@ApplicationScoped
public class JpaVlanRepository implements VlanRepository {

  @PersistenceContext
  protected EntityManager entityManager;
  
  @Override
  public void add(Vlan vlan) throws RepositoryException {
    try {
      entityManager.persist(vlan);
      
      // execute pending SQL ("flush changes to database") so that we can
      // trap constraint violations and re-throw as our own exception type
      entityManager.flush();         
    }
    catch (PersistenceException ex) {
      throw new RepositoryException(ex);
    }
  }

}
