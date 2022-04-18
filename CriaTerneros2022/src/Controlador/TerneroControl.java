package Controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import EJB.TerneroEJBLocal;
import Entidades.Ternero;
@Named("terneroControlNamed")
@ViewScoped

public class TerneroControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private TerneroEJBLocal terneroEJB;
	private Ternero usuario;
	private List<Ternero> Terneros;

	private List<Ternero> seleccionados;

	private Ternero selectedTernero;

	public Ternero getSelectedTernero() {
		return selectedTernero;
	}

	public void setSelectedTernero(Ternero selectedTernero) {
		this.selectedTernero = selectedTernero;
	}

	public List<Ternero> getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(List<Ternero> seleccionados) {
		this.seleccionados = seleccionados;
	}

	public List<Ternero> getTerneros() {
		return Terneros;
	}

	public void setTerneros(List<Ternero> usuarios) {
		Terneros = usuarios;
	}

	public Ternero getTernero() {
		return usuario;
	}

	public void setTernero(Ternero usuario) {
		this.usuario = usuario;
	}

	public boolean hasSelectedTerneros() {
		return this.seleccionados != null && !this.seleccionados.isEmpty();
	}

	public String getDeleteButtonMessage() {
		if (hasSelectedTerneros()) {
			int size = this.seleccionados.size();
			return size > 1 ? size + " Terneros seleccionados" : "1 Ternero seleccionado";
		}

		return "Borrar";
	}

	@PostConstruct
	public void init() {
		this.Terneros = this.terneroEJB.findAll();
	}

	public void openNew() {
		if (selectedTernero == null) {
			this.selectedTernero = new Ternero();
		}

	}

	public void crear() {
		if (selectedTernero == null) {
			try {
				this.terneroEJB.crear(this.selectedTernero);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ternero añadido"));
				
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ternero no añadido"));
				e.getStackTrace();
			}
		} else {
			try {
				this.terneroEJB.editar(this.selectedTernero);
				this.selectedTernero= null;
				PrimeFaces.current().executeScript("PF('manageTerneroDialog').hide()");
		        PrimeFaces.current().ajax().update("form:dt-Terneros");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ternero editado"));
				
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ternero no editado"));
				e.getMessage();
			}
		}
		
		

	}

	public void eliminar() {
		try {
			this.terneroEJB.remove(this.selectedTernero);
			this.selectedTernero = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ternero eliminado"));
			PrimeFaces.current().executeScript("PF('manageTerneroDialog').hide()");
			PrimeFaces.current().ajax().update("form:messages", "form");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ternero no eliminado"));
			e.getMessage();
		}
		
		
		
	}

}