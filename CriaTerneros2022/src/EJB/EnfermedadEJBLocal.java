package EJB;

import java.util.List;

import javax.ejb.Local;

import Entidades.Enfermedad;

@Local
public interface EnfermedadEJBLocal {
	
	
void crear(Enfermedad enfermedad);
	
	void editar(Enfermedad enfermedad);
	
	void eliminar(Enfermedad enfermedad);
	
	Enfermedad find(Object id);
	
	List<Enfermedad> findAll();
	
	int count();

}
