package school.webservice;

public class WSUtils {
	public static final String q_user = "SELECT p from " + "User" + " p where p.username = :userN";
	public static final String q_image = "SELECT p from " + "Image p";
	public static final String q_sound = "SELECT p from " + "Sound p";
	public static final String q_sound_id = q_sound + " where p.idsound=:id";
	public static final String q_level_resources = "SELECT p from " + "Levelresource p";
	public static final String q_image_name = q_image + " where p.path=:name";
	public static final String q_level_res_id = q_level_resources + " where p.idLevel=:id and p.type=:type";
	public static final String q_image_id = q_image + " where p.idimage=:id";
}
