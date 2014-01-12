package school.webservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import school.model.User;

@Path("UserService")
public class UserCRUD {

	@PersistenceContext(unitName = "School")
	EntityManager em;
	private Query query;
	private String q = "SELECT p from " + "User" + " p where p.username = :userN";

	public UserCRUD() {
	}

	public UserCRUD(EntityManager em, String q) {
		this.q = q;
		this.em = em;
	}

	// http://localhost:8080/LoginApp/rest/UserService/read/user
	@SuppressWarnings("unchecked")
	@GET
	@Path("/read/{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public User read(@PathParam("user") String username) {
		try {
			if (username != null) {
				query = em.createQuery(q);
				query.setParameter("userN", username);
				List<User> users = query.getResultList();
				if (users.size() > 0) {
					return users.get(0);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	// http://localhost:8080/LoginApp/rest/UserService/exists/user
	@SuppressWarnings("unchecked")
	@GET
	@Path("/exists/{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean checkUser(@PathParam("user") String username) {
		try {
			if (username != null) {
				query = em.createQuery(q);
				query.setParameter("userN", username);
				List<User> users = query.getResultList();
				if (users.size() > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@POST
	@Path("/create")
	@Consumes("application/json")
	public boolean create(User user) {
		em.persist(user);
		return true;
	}
}