package mtm.vlanmgr.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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

  @Override
  public Vlan update(Vlan vlan) throws RepositoryException {
    return entityManager.merge(vlan);
  }

  @Override
  public Vlan findById(Long id) {
    TypedQuery<Vlan> query = entityManager.createNamedQuery(
        "findVlanById", Vlan.class);
    query.setParameter("id", id);
    return query.getSingleResult();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Vlan> findAll() {
    TypedQuery<Vlan> query = entityManager.createNamedQuery(
        "findAllVlans", Vlan.class);
    return query.getResultList();
  }

}
