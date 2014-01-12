package school.webservice;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import school.model.User;

@Path("LogInService")
public class Login {

	@Inject
	EntityManager em;
	private Query query;
	private String q = "SELECT p from " + "User" + " p where p.username = :userN";

	public Login() {
	}

	public Login(EntityManager em, String q) {
		this.q = q;
		this.em = em;
	}

	// http://localhost:8080/SchoolServerRest/rest/LogInService/login/
	@SuppressWarnings("unchecked")
	@POST
	@Path("/login")
	@Consumes("application/json")
	public String login(User user) {
		try {
			if (user.getUsername() != null && user.getPassword() != null) {
				query = em.createQuery(q);
				query.setParameter("userN", user.getUsername());
				List<User> users = query.getResultList();
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
