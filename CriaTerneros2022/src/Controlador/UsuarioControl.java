package Controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import EJB.UsuarioEJBLocal;
import Entidades.Usuario;

@Named("usuarioControlNamed")
@ViewScoped
public class UsuarioControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioEJBLocal usuarioEJB;
	private Usuario usuario;
	private List<Usuario> Usuarios;

	private List<Usuario> seleccionados;

	private Usuario selectedUsuario;

	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	public List<Usuario> getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(List<Usuario> seleccionados) {
		this.seleccionados = seleccionados;
	}

	public List<Usuario> getUsuarios() {
		return Usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		Usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean hasSelectedUsuarios() {
		return this.seleccionados != null && !this.seleccionados.isEmpty();
	}

	public String getDeleteButtonMessage() {
		if (hasSelectedUsuarios()) {
			int size = this.seleccionados.size();
			return size > 1 ? size + " Usuarios seleccionados" : "1 Usuario seleccionado";
		}

		return "Borrar";
	}

	@PostConstruct
	public void init() {
		this.Usuarios = this.usuarioEJB.findAll();
	}

	public void openNew() {
		if (selectedUsuario == null) {
			this.selectedUsuario = new Usuario();
		}

	}

	public void crear() {
		if (selectedUsuario == null) {
			try {
				this.usuarioEJB.crear(this.selectedUsuario);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario añadido"));
				
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario no añadido"));
				e.getStackTrace();
			}
		} else {
			try {
				this.usuarioEJB.editar(this.selectedUsuario);
				this.selectedUsuario= null;
				PrimeFaces.current().executeScript("PF('manageUsuarioDialog').hide()");
		        PrimeFaces.current().ajax().update("form:messages", "form");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario editado"));
				
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario no editado"));
				e.getMessage();
			}
		}
		
		

	}

	public void eliminar() {
		try {
			this.usuarioEJB.remove(this.selectedUsuario);
			this.selectedUsuario = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario eliminado"));
			PrimeFaces.current().executeScript("PF('manageUsuarioDialog').hide()");
			PrimeFaces.current().ajax().update("form:messages", "form");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario no eliminado"));
			e.getMessage();
		}
		
		
		
	}

}
