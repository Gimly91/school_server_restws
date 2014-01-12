package school.webservices;

import static org.junit.Assert.assertEquals;
import static school.webservices.TestUtils.adminUser;
import static school.webservices.TestUtils.noUser;
import static school.webservices.TestUtils.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.mockito.Mockito;

import school.db.UserDAO;
import school.model.User;
import school.webservice.Login;

public class TestLogin {

	@Test
	public void testLogIn() {
		List<User> usersT = new ArrayList<>();
		usersT.add(adminUser);
		Query query = Mockito.mock(Query.class);
		UserDAO userDAO = Mockito.mock(UserDAO.class);
		userDAO.setQuery(query);
		Login lb = new Login(userDAO);

		Mockito.when(userDAO.getUsers(adminUser)).thenReturn(usersT);

		usersT.add(adminUser);
		assertEquals(adminUser.getType(), lb.login(adminUser));

		users.remove(0);
		Mockito.when(query.getResultList()).thenReturn(users);
		assertEquals("noUser", lb.login(noUser));

		users.add(adminUser);
		Mockito.when(query.getResultList()).thenReturn(users);
	}
}
