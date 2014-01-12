package school.webservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static school.webservices.TestUtils.adminUser;
import static school.webservices.TestUtils.users;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.mockito.Mockito;

import school.webservice.UserCRUD;

public class TestUserCRUD {

	@Test
	public void read() {
		EntityManager em = Mockito.mock(EntityManager.class);
		String q = "SELECT p from " + "user" + " p where p.username = :userN";
		Query query = Mockito.mock(Query.class);

		UserCRUD lb = new UserCRUD(em, q);

		Mockito.when(em.createQuery(q)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(users);

		assertEquals(adminUser, lb.read(adminUser.getUsername()));

		users.remove(0);
		users.remove(0);

		assertNull(lb.read(adminUser.getUsername()));
	}
	
	@Test
	public void check() {
		EntityManager em = Mockito.mock(EntityManager.class);
		String q = "SELECT p from " + "user" + " p where p.username = :userN";
		Query query = Mockito.mock(Query.class);

		UserCRUD lb = new UserCRUD(em, q);

		Mockito.when(em.createQuery(q)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(users);

		users.add(adminUser);
		assertTrue(lb.checkUser(adminUser.getUsername()));

		users.remove(0);
		assertFalse(lb.checkUser(adminUser.getUsername()));
	}
}
