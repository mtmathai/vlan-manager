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
			entityManager.flush();
		}
		catch (PersistenceException ex) {
			throw new RepositoryException(ex);
		}
	}

}
