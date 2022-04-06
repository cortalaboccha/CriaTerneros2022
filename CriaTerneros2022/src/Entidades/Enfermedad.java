package Entidades;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENFERMEDADES")
public class Enfermedad implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue (strategy= GenerationType.SEQUENCE)
	@Column(nullable = false, name= "ID")
	private int id;
	
	@Column(nullable = false, name= "nroTernero")	
	private String nroTernero;
	
	
	//nacimiento
	@Column(nullable = false, name= "fechaNac")	
    private Date fechaNac;
	@Column(nullable = false, name= "parto")	
    private String parto;
	@Column(nullable = false, name= "peso")	
    private double peso;
    
    //calostrado
	@Column(nullable = false, name= "cantCal")	
    private double cantCal;
	@Column(nullable = false, name= "tiempo")	
    private int tiempo;
    
    //refractometria
	@Column(nullable = false, name= "fechaRef")	
    private Date fechaRef;
	@Column(nullable = false, name= "valor")	
    private double valor;
    
    //desleche
	@Column(nullable = false, name= "fechaDes")	
    private Date fechaDes;
	@Column(nullable = false, name= "pesoDes")	
    private double pesoDes;
	@Column(nullable = false, name= "altura")	
    private double altura;

    
    public Enfermedad() {
    }
   

    public Enfermedad(int id, String nroTernero, Date fechaNac, String parto, double peso, double cantCal, int tiempo, Date fechaRef,
			double valor, Date fechaDes, double pesoDes, double altura) {
		super();
		this.id = id;
		this.nroTernero= nroTernero;
		this.fechaNac = fechaNac;
		this.parto = parto;
		this.peso = peso;
		this.cantCal = cantCal;
		this.tiempo = tiempo;
		this.fechaRef = fechaRef;
		this.valor = valor;
		this.fechaDes = fechaDes;
		this.pesoDes = pesoDes;
		this.altura = altura;
	}



	@Override
    public Enfermedad clone() {
        return new Enfermedad(getId(), getNroTernero(), getFechaNac(), getParto(), getPeso(), getCantCal(), getTiempo(), getFechaRef(), getValor(), getFechaDes(), getPesoDes(), getAltura());
    }

	
	
   
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	  public String getNroTernero() {
			return nroTernero;
		}


		public void setNroTernero(String nroTernero) {
			this.nroTernero = nroTernero;
		}



	public Date getFechaNac() {
		return fechaNac;
	}



	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}



	public String getParto() {
		return parto;
	}



	public void setParto(String parto) {
		this.parto = parto;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public double getCantCal() {
		return cantCal;
	}



	public void setCantCal(double cantCal) {
		this.cantCal = cantCal;
	}



	public int getTiempo() {
		return tiempo;
	}



	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}



	public Date getFechaRef() {
		return fechaRef;
	}



	public void setFechaRef(Date fechaRef) {
		this.fechaRef = fechaRef;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public Date getFechaDes() {
		return fechaDes;
	}



	public void setFechaDes(Date fechaDes) {
		this.fechaDes = fechaDes;
	}



	public double getPesoDes() {
		return pesoDes;
	}



	public void setPesoDes(double pesoDes) {
		this.pesoDes = pesoDes;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nroTernero == null) ? 0 : nroTernero.hashCode());
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
        Enfermedad other = (Enfermedad) obj;
        if (nroTernero == null) {
            return other.nroTernero == null;
        }
        else {
            return nroTernero.equals(other.nroTernero);
        }
    }

}