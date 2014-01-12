package school.webservice;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import school.db.UserDAO;
import school.model.User;

@Path("UserService")
public class UserCRUD {

	@PersistenceContext(unitName = "School")
	EntityManager em;

	private static final Logger LOGGER = Logger.getLogger(UserCRUD.class.getName());
	
	private UserDAO userDAO;

	public UserCRUD() {
	}

	public UserCRUD(UserDAO uD) {
		this.userDAO = uD;
	}

	// http://localhost:8080/LoginApp/rest/UserService/read/user
	@GET
	@Path("/read/{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public User read(@PathParam("user") String username) {
		try {
			if (username != null) {
				userDAO.setEm(em);
				return userDAO.getUser(username);
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	// http://localhost:8080/LoginApp/rest/UserService/exists/user
	@GET
	@Path("/exists/{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean checkUser(@PathParam("user") String username) {
		try {
			if (username != null) {
				userDAO.setEm(em);
				if (userDAO.getUser(username) != null) {
					return true;
				}
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		return false;
	}

	@POST
	@Path("/create")
	@Consumes("application/json")
	public boolean create(User user) {
		userDAO.setEm(em);
		return userDAO.saveUser(user);
	}
}