package school.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the level database table.
 * 
 */
@Entity
@NamedQuery(name="Level.findAll", query="SELECT l FROM Level l")
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idlevel;

	private String description;

	private String name;

	public Level() {
	}

	public int getIdlevel() {
		return this.idlevel;
	}

	public void setIdlevel(int idlevel) {
		this.idlevel = idlevel;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}