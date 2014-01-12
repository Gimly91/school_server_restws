package school.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the levelresource database table.
 * 
 */
@Entity
@NamedQuery(name="Levelresource.findAll", query="SELECT l FROM Levelresource l")
public class Levelresource implements Serializable {
	private static final long serialVersionUID = 1L;

	private int type;
	
	@Id
	private int idResource;

	private int idLevel;

	public Levelresource() {
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIdResource() {
		return idResource;
	}

	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}

	public int getIdLevel() {
		return idLevel;
	}

	public void setIdLevel(int idLevel) {
		this.idLevel = idLevel;
	}
}