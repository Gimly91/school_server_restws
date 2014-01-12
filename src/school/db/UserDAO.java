package school.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import school.model.User;
import static school.webservice.WSUtils.*;

public class UserDAO {

	private EntityManager em;
	private Query query;

	public UserDAO() {
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public UserDAO(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers(User user) {
		query = em.createQuery(Q_USER);
		query.setParameter("userN", user.getUsername());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public User getUser(String username) {
		query = em.createQuery(Q_USER);
		query.setParameter("userN", username);
		List<User> users = query.getResultList();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	public boolean saveUser(User user) {
		em.persist(user);
		return true;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
}
