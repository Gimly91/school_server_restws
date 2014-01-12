package school.webservices;

import java.util.ArrayList;
import java.util.List;

import school.model.User;

public class TestUtils {

	public static final User adminUser = new User();
	public static final User simpleUser = new User();
	public static final User unknownUser = new User();
	public static final User noUser = null;
	public static List<User> users = new ArrayList<User>();

	static {
		adminUser.setType("Admin");
		adminUser.setUsername("admin");
		adminUser.setPassword("pass");
		simpleUser.setType("User");
		simpleUser.setUsername("admin");
		simpleUser.setPassword("pass");
		unknownUser.setType("NNN");
		users.add(adminUser);
		users.add(simpleUser);
	}
}
