package EJB;

import java.util.List;

import javax.ejb.Local;

import Entidades.Ternero;

@Local
public interface TerneroEJBLocal {
	
	void crear(Ternero Ternero);
	
	void editar(Ternero Ternero);
	
	void remove(Ternero Ternero);
	
	Ternero find(Object id);
	
	List<Ternero> findAll();
	
	int count();
	
}
