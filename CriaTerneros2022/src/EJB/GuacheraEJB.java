package EJB;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entidades.Guachera;


@Stateless
public class GuacheraEJB extends AbstractFacade<Guachera> implements GuacheraEJBLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override 
	protected EntityManager getEntityManager() {
		return em;
	}
 
    public GuacheraEJB() {
    	super(Guachera.class);
    }

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}


}
