package school.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the keypoints database table.
 * 
 */
@Entity
@Table(name="keypoints")
@NamedQuery(name="Keypoint.findAll", query="SELECT k FROM Keypoint k")
public class Keypoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coor_x")
	private int coorX;

	@Column(name="coor_y")
	private int coorY;

	private String description;
	
	@Column(name="idImage")
	private int idImage;

	public Keypoint() {
	}

	public int getCoorX() {
		return this.coorX;
	}

	public void setCoorX(int coorX) {
		this.coorX = coorX;
	}

	public int getCoorY() {
		return this.coorY;
	}

	public void setCoorY(int coorY) {
		this.coorY = coorY;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
}