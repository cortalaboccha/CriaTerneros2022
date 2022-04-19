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

import EJB.GuacheraEJBLocal;
import Entidades.Guachera;

@Named("guacheraControlNamed")
@ViewScoped
public class GuacheraControl implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@EJB
	GuacheraEJBLocal guacheraEJB;
	private Guachera Guachera;
	private List<Guachera> Guacheras;
	
	private Guachera selectedGuachera;
	
	private List<Guachera> seleccionados;

	public Guachera getSelectedGuachera() {
		return selectedGuachera;
	}

	public void setSelectedGuachera(Guachera selectedGuachera) {
		this.selectedGuachera = selectedGuachera;
	}
	public List<Guachera> getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(List<Guachera> seleccionados) {
		this.seleccionados = seleccionados;
	}
	
	
	public List<Guachera> getGuacheras() {
		return Guacheras;
	}

	public void setGuacheras(List<Guachera> guacheras) {
		Guacheras = guacheras;
	}
	

	public Guachera getGuachera() {
		return Guachera;
	}

	public void setGuachera(Guachera Guachera) {
		this.Guachera = Guachera;
	}
	
	
	@PostConstruct
	public void init() {
		this.Guacheras = this.guacheraEJB.findAll();
	}
	
	public void openNew() {
		if (selectedGuachera == null) {
			this.selectedGuachera = new Guachera();
		}
	}
	public boolean hasSelectedGuacheras() {
			return this.seleccionados != null && !this.seleccionados.isEmpty();
		}

	public String getDeleteButtonMessage() {
			if (hasSelectedGuacheras()) {
				int size = this.seleccionados.size();
				return size > 1 ? size + " Guacheras seleccionados" : "1 Guachera seleccionada";
			}

			return "Borrar";	

	}
	public void crear() {
		if (selectedGuachera == null) {
			try {
				this.guacheraEJB.crear(this.selectedGuachera);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guachera añadido"));
				
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guachera no añadido"));
				e.getStackTrace();
			}
		} else {
			try {
				this.guacheraEJB.editar(this.selectedGuachera);
				this.selectedGuachera= null;
				PrimeFaces.current().executeScript("PF('manageGuacheraDialog').hide()");
		        PrimeFaces.current().ajax().update("form:dt-Guacheras");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guachera editado"));
				
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guachera no editado"));
				e.getMessage();
			}
		}
		
		

	}

	public void eliminar() {
		
		
		try {
			this.guacheraEJB.remove(this.selectedGuachera);
			this.selectedGuachera = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guachera eliminado"));
			PrimeFaces.current().executeScript("PF('manageGuacheraDialog').hide()");
			PrimeFaces.current().ajax().update("form:messages", "form");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guachera no eliminado"));
			e.getMessage();
		}
		
		
		
	}
}
