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
@Named
@ViewScoped
public class GuacheraControl implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@EJB
	GuacheraEJBLocal guacherasEJB;
	private Guachera Guachera;
	private List<Guachera> Guacheras;
	
	@PostConstruct
	public void init() {
		this.Guacheras = this.guacherasEJB.findAll();	
	}
	
	public List<Guachera> getGuacheras() {
		return Guacheras;
	}

	public void setGuacheras(List<Guachera> guacheras) {
		Guacheras = guacheras;
	}
	

	public Guachera getTernero() {
		return Guachera;
	}

	public void setTernero(Guachera Guachera) {
		this.Guachera = Guachera;
	}
	
	public void crear() {
		try {
			guacherasEJB.crear(Guachera);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guachera añadido"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guachera no añadido"));
			e.getStackTrace();
		}
		
		PrimeFaces.current().executeScript("PF('manageTerneroDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-Guachera");
        
	}

}
