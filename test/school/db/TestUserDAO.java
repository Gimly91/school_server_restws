package school.db;

import static org.junit.Assert.*;
import static school.webservice.WSUtils.Q_USER;
import static school.webservices.TestUtils.adminUser;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.mockito.Mockito;

import school.model.User;

public class TestUserDAO {

	@Test
	public void testgetUser() {
		List<User> usersT = new ArrayList<User>();
		usersT.add(adminUser);
		EntityManager em = Mockito.mock(EntityManager.class);
		Query query = Mockito.mock(Query.class);

		UserDAO lb = new UserDAO(em);
		lb.setQuery(query);

		Mockito.when(em.createQuery(Q_USER)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(usersT);

		assertEquals(adminUser, lb.getUser(adminUser.getUsername()));

	}

	@Test
	public void testgetUsers() {
		List<User> usersT = new ArrayList<User>();
		usersT.add(adminUser);
		EntityManager em = Mockito.mock(EntityManager.class);
		Query query = Mockito.mock(Query.class);

		UserDAO lb = new UserDAO(em);
		lb.setQuery(query);

		Mockito.when(em.createQuery(Q_USER)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(usersT);

		assertEquals(usersT, lb.getUsers(adminUser));

	}

	@Test
	public void testsaveUsers() {
		List<User> usersT = new ArrayList<User>();
		usersT.add(adminUser);
		EntityManager em = Mockito.mock(EntityManager.class);
		Query query = Mockito.mock(Query.class);

		UserDAO lb = new UserDAO(em);
		lb.setQuery(query);
		assertTrue(lb.saveUser(adminUser));

	}
}
