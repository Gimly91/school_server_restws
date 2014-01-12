package school.webservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static school.webservices.TestUtils.adminUser;
import static school.webservices.TestUtils.unknownUser;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import org.mockito.Mockito;

import school.db.UserDAO;
import school.model.User;
import school.webservice.UserCRUD;

public class TestUserCRUD {

	@Test
	public void read() {
		List<User> usersT = new ArrayList<>();
		usersT.add(adminUser);
		Query query = Mockito.mock(Query.class);
		UserDAO userDAO = Mockito.mock(UserDAO.class);
		userDAO.setQuery(query);

		UserCRUD lb = new UserCRUD(userDAO);

		Mockito.when(userDAO.getUser(adminUser.getUsername())).thenReturn(adminUser);
		Mockito.when(userDAO.getUser(unknownUser.getUsername())).thenReturn(unknownUser);

		assertEquals(adminUser, lb.read(adminUser.getUsername()));
		assertNull(lb.read(unknownUser.getUsername()));
	}

	@Test
	public void check() {
		List<User> usersT = new ArrayList<>();
		usersT.add(adminUser);
		Query query = Mockito.mock(Query.class);
		UserDAO userDAO = Mockito.mock(UserDAO.class);
		userDAO.setQuery(query);

		UserCRUD lb = new UserCRUD(userDAO);

		Mockito.when(userDAO.getUser(adminUser.getUsername())).thenReturn(adminUser);
		Mockito.when(userDAO.getUser(unknownUser.getUsername())).thenReturn(unknownUser);

		assertTrue(lb.checkUser(adminUser.getUsername()));
		assertFalse(lb.checkUser(unknownUser.getUsername()));
	}

	@Test
	public void saveUser() {
		List<User> usersT = new ArrayList<>();
		usersT.add(adminUser);
		Query query = Mockito.mock(Query.class);
		UserDAO userDAO = Mockito.mock(UserDAO.class);
		userDAO.setQuery(query);

		UserCRUD lb = new UserCRUD(userDAO);

		Mockito.when(userDAO.saveUser(adminUser)).thenReturn(true);
		assertTrue(lb.create(adminUser));
	}
}
