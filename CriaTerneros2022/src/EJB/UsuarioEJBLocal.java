package EJB;

import java.util.List;

import javax.ejb.Local;

import Entidades.Usuario;

@Local
public interface UsuarioEJBLocal {
	
	void crear(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void remove(Usuario usuario);
	
	Usuario find(Object id);
	
	List<Usuario> findAll();
	
	//int count();
	
}
