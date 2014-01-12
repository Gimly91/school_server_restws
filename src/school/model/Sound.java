package school.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sound database table.
 * 
 */
@Entity
@NamedQuery(name="Sound.findAll", query="SELECT s FROM Sound s")
public class Sound implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idsound;

	private String description;

	private String path;

	public Sound() {
	}

	public int getIdsound() {
		return this.idsound;
	}

	public void setIdsound(int idsound) {
		this.idsound = idsound;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}