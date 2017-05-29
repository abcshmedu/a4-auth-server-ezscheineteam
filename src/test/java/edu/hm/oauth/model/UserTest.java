package edu.hm.oauth.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUserConstructorAndGetSet() {
		User user = new User("Test","Test","Test@test.de",UserGroup.ADMIN);
		assertEquals(user.getName(), "Test");
		assertEquals("Test", user.getPassword());
		assertEquals("Test@test.de", user.getEmail());
		assertEquals(UserGroup.ADMIN, user.getGroup());
		user.setName("testtest");
		assertEquals(user.getName(), "testtest");
		user.setPassword("newpass");
		assertEquals("newpass", user.getPassword());
		assertTrue(user.isActive());
		user.setActive(false);
		assertFalse(user.isActive());
		user.setGroup(UserGroup.NORMAL);
		assertEquals(UserGroup.NORMAL, user.getGroup());
		user.setEmail("new@mail.de");
		assertEquals("new@mail.de", user.getEmail());
		user.setiD(555);
		assertEquals(user.getiD(), 555);
	}
}
