package Entidades;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.SEQUENCE)
	@Column(nullable = false, name= "ID")
	private int id;
	@Column(nullable = false, name= "NOMBRE")
	private String nombre;
	@Column(nullable = false, name= "APELLIDO")
	private String apellido;
	@Column(nullable = false, name= "MAIL")
    private String mail;
	@Column(nullable = false, name= "CEDULA")
    private int cedula;
	@Column(nullable = false, name= "TELEFONO")
    private int telefono;
	@Column(nullable = false, name= "ACCESO")
    private String nomAcc;
	@Column(nullable = false, name= "CONTRASENA")
    private String contra;
    
    
    public Usuario() {
    }
   

    public Usuario(int id, String nombre, String apellido, String mail, int cedula,int telefono, String nomAcc, String contra) {
		super();
		this.id = id;
		this.nombre= nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.telefono = telefono;
		this.nomAcc = nomAcc;
		this.contra = contra;
	}



	@Override
    public Usuario clone() {
        return new Usuario(getId(), getNombre(), getApellido(), getMail(), getCedula(), getTelefono(), getNomAcc(), getContra());
    }

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getCedula() {
		return cedula;
	}


	public void setCedula(int cedula) {
		this.cedula = cedula;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	public String getNomAcc() {
		return nomAcc;
	}


	public void setNomAcc(String nomAcc) {
		this.nomAcc = nomAcc;
	}


	public String getContra() {
		return contra;
	}


	public void setContra(String contra) {
		this.contra = contra;
	}


	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        if (nombre == null) {
            return other.nombre == null;
        }
        else {
            return nombre.equals(other.nombre);
        }
    }

}