package Entidades;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "GUACHERAS")
public class Guachera implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.SEQUENCE)
	@Column(nullable = false, name= "ID")
	private int id;
	
	@Column(nullable = false, name= "nroGuachera")	
	private String nroGuachera;
	
	private String tipoGuachera;
	private String observaciones;
    

    
    public Guachera() {
    }
   

    public Guachera(int id, String nroGuachera, String tipoGuachera, String observaciones) {
		super();
		this.id = id;
		this.nroGuachera= nroGuachera;
		this.tipoGuachera = tipoGuachera;
		this.observaciones = observaciones;
	}



	@Override
    public Guachera clone() {
        return new Guachera(getId(), getnroGuachera(), getTipoGuachera(), getObservaciones());
    }

	
	
   
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	  public String getnroGuachera() {
			return nroGuachera;
		}


		public void setnroGuachera(String nroGuachera) {
			this.nroGuachera = nroGuachera;
		}





	

		public String getTipoGuachera() {
			return tipoGuachera;
		}


		public void setTipoGuachera(String tipoGuachera) {
			this.tipoGuachera = tipoGuachera;
		}


		public String getObservaciones() {
			return observaciones;
		}


		public void setObservaciones(String observaciones) {
			this.observaciones = observaciones;
		}


	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nroGuachera == null) ? 0 : nroGuachera.hashCode());
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
        Guachera other = (Guachera) obj;
        if (nroGuachera == null) {
            return other.nroGuachera == null;
        }
        else {
            return nroGuachera.equals(other.nroGuachera);
        }
    }

}