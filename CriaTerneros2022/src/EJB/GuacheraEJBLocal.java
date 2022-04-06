package EJB;

import java.util.List;

import javax.ejb.Local;

import Entidades.Guachera;

@Local
public interface GuacheraEJBLocal {
	
	void crear(Guachera guachera);
	
	void editar(Guachera guachera);
	
	void remove(Guachera guachera);
	
	Guachera find(Object id);
	
	List<Guachera> findAll();
	
	int count();
	
}
