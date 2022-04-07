package EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entidades.Enfermedad;




/**
 * Session Bean implementation class EnfermedadEJB
 */
@Stateless

public class EnfermedadEJB extends AbstractFacade<Enfermedad> implements EnfermedadEJBLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager em;
	
	@Override 
	protected EntityManager getEntityManager() {
		return em;
	}
    public EnfermedadEJB() {
    	super(Enfermedad.class);
        // TODO Auto-generated constructor stub
    }
   
	}

