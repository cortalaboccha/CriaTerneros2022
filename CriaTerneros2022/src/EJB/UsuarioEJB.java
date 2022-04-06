package EJB;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entidades.Usuario;


@Stateless
public class UsuarioEJB extends AbstractFacade<Usuario> implements UsuarioEJBLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override 
	protected EntityManager getEntityManager() {
		return em;
	}
 
    public UsuarioEJB() {
    	super(Usuario.class);
    }



}
