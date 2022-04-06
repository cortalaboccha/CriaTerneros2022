package Controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("loginControlNamed")
@ViewScoped
public class LoginControl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init() {
		
	}
	
	public String ingresar() {
		return "CriaT";
	}
	
	

}
