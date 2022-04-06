package EJB;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entidades.Ternero;


@Stateless
public class TerneroEJB extends AbstractFacade<Ternero> implements TerneroEJBLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override 
	protected EntityManager getEntityManager() {
		return em;
	}
 
    public TerneroEJB() {
    	super(Ternero.class);
    }

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
