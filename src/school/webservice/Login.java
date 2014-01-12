package school.webservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import school.db.UserDAO;
import school.model.User;

@Path("LogInService")
public class Login {

	@PersistenceContext(unitName = "School")
	EntityManager em;
	private UserDAO userDAO;

	public Login() {
	}

	public Login(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	// http://localhost:8080/SchoolServerRest/rest/LogInService/login/
	@POST
	@Path("/login")
	@Consumes("application/json")
	public String login(User user) {
		try {
			if (user.getUsername() != null && user.getPassword() != null) {
				userDAO.setEm(em);
				List<User> users = userDAO.getUsers(user);
				if (users.size() > 0) {
					User p = users.get(0);
					if (p != null) {
						String pass = user.getPassword();
						if (pass.equals(p.getPassword())) {
							return p.getType();
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "noUser";
	}
}
