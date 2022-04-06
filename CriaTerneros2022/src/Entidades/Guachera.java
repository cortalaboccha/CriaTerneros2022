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
	
	private String individual;
    private String colectiva;
    

    
    public Guachera() {
    }
   

    public Guachera(int id, String nroGuachera, String individual, String colectiva) {
		super();
		this.id = id;
		this.nroGuachera= nroGuachera;
		this.individual = individual;
		this.colectiva = colectiva;
	}



	@Override
    public Guachera clone() {
        return new Guachera(getId(), getnroGuachera(), getindividual(), getcolectiva());
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


	public String getindividual() {
		return individual;
	}



	public void setindividual(String individual) {
		this.individual = individual;
	}



	public String getcolectiva() {
		return colectiva;
	}



	public void setcolectiva(String colectiva) {
		this.colectiva = colectiva;
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