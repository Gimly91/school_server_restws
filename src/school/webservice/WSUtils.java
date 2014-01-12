package school.webservice;

public class WSUtils {
	private WSUtils() {
	}

	public static final String Q_USER = "SELECT p from " + "User" + " p where p.username = :userN";
	public static final String Q_IMAGE = "SELECT p from " + "Image p";
	public static final String Q_SOUND = "SELECT p from " + "Sound p";
	public static final String Q_SOUND_ID = Q_SOUND + " where p.idsound=:id";
	public static final String Q_LEVEL_RES = "SELECT p from " + "Levelresource p";
	public static final String Q_IMAGE_NAME = Q_IMAGE + " where p.path=:name";
	public static final String Q_LEVEL_RES_ID = Q_LEVEL_RES + " where p.idLevel=:id and p.type=:type";
	public static final String Q_IMAGE_ID = Q_IMAGE + " where p.idimage=:id";
}
