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

import EJB.EnfermedadEJBLocal;
import Entidades.Enfermedad;

@Named
@ViewScoped

public class EnfermedadControl implements Serializable {
	
	
private static final long serialVersionUID = 1L;
	
	@EJB
	EnfermedadEJBLocal enfermedadesEJB;
	private Enfermedad Enfermedad;
	private List<Enfermedad> Enfermedades;
	
	@PostConstruct
	public void init() {
		this.Enfermedades = this.enfermedadesEJB.findAll();	
	}
	
	public List<Enfermedad> getEnfermedads() {
		return Enfermedades;
	}

	public void setEnfermedads(List<Enfermedad> enfermedades) {
		Enfermedades = enfermedades;
	}
	

	public Enfermedad getTernero() {
		return Enfermedad;
	}

	public void setTernero(Enfermedad Enfermedad) {
		this.Enfermedad = Enfermedad;
	}
	
	public void crear() {
		try {
			enfermedadesEJB.crear(Enfermedad);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Enfermedad añadido"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Enfermedad no añadido"));
			e.getStackTrace();
		}
		
		PrimeFaces.current().executeScript("PF('manageTerneroDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-Enfermedad");
        
	}


}
