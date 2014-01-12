package school.webservices;

import static org.junit.Assert.assertEquals;
import static school.webservices.TestUtils.adminUser;
import static school.webservices.TestUtils.noUser;
import static school.webservices.TestUtils.users;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.mockito.Mockito;

import school.webservice.Login;

public class TestLogin {

	@Test
	public void testLogIn() {
		EntityManager em = Mockito.mock(EntityManager.class);
		String q = "SELECT p from " + "user" + " p where p.username = :userN";
		Query query = Mockito.mock(Query.class);

		Login lb = new Login(em, q);

		Mockito.when(em.createQuery(q)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(users);

		users.add(adminUser);
		assertEquals(adminUser.getType(), lb.login(adminUser));

		users.remove(0);
		Mockito.when(query.getResultList()).thenReturn(users);
		assertEquals("noUser", lb.login(noUser));

		users.add(adminUser);
		Mockito.when(query.getResultList()).thenReturn(users);
	}
}
