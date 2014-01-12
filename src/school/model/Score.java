package school.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the score database table.
 * 
 */
@Entity
@NamedQuery(name="Score.findAll", query="SELECT s FROM Score s")
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;

	private int score;

	private int idLevel;

	public Score() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getIdLevel() {
		return idLevel;
	}

	public void setIdLevel(int idLevel) {
		this.idLevel = idLevel;
	}
}