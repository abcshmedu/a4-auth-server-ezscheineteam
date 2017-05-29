package edu.hm.oauth.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.oauth.model.User;
import edu.hm.oauth.model.UserGroup;

public class UserRepositoryStubTest {

	UserRepositoryStub stub = new UserRepositoryStub();
	User u = new User("test", "test", "test@test.de", UserGroup.NORMAL);

	@Test
	public void testUserRepository() {
		stub.createUser(u);
		assertEquals(u, stub.getUser(u.getName()));
		assertNull(stub.getUser("notExisting"));
		assertEquals(stub.getAllUsers().size(), 6);
	}
}
