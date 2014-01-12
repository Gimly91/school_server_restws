package school.webservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static school.webservices.TestUtils.*;
import static school.webservices.TestUtils.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.mockito.Mockito;

import school.model.User;
import school.webservice.UserCRUD;

public class TestUserCRUD {

	@Test
	public void read() {
		List<User> usersT = new ArrayList<>();
		usersT.add(adminUser);
		usersT.add(simpleUser);
		EntityManager em = Mockito.mock(EntityManager.class);
		String q = "SELECT p from " + "user" + " p where p.username = :userN";
		Query query = Mockito.mock(Query.class);

		UserCRUD lb = new UserCRUD(em, q);

		Mockito.when(em.createQuery(q)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(usersT);

		assertEquals(adminUser, lb.read(adminUser.getUsername()));

		usersT.remove(0);
		usersT.remove(0);

		assertNull(lb.read(adminUser.getUsername()));
	}

	@Test
	public void check() {
		List<User> usersT = new ArrayList<>();
		EntityManager em = Mockito.mock(EntityManager.class);
		String q = "SELECT p from " + "user" + " p where p.username = :userN";
		Query query = Mockito.mock(Query.class);

		UserCRUD lb = new UserCRUD(em, q);

		Mockito.when(em.createQuery(q)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(usersT);

		usersT.add(adminUser);
		assertTrue(lb.checkUser(adminUser.getUsername()));

		usersT.remove(0);
		assertFalse(lb.checkUser(adminUser.getUsername()));
	}
}
