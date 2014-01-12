package school.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idimage;

	private String description;

	private int idKeyPoints;

	private String path;

	public Image() {
	}

	public int getIdimage() {
		return this.idimage;
	}

	public void setIdimage(int idimage) {
		this.idimage = idimage;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdKeyPoints() {
		return this.idKeyPoints;
	}

	public void setIdKeyPoints(int idKeyPoints) {
		this.idKeyPoints = idKeyPoints;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}