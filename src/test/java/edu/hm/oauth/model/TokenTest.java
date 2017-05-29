package edu.hm.oauth.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TokenTest {

	@Test
	public void testTokenConstructorAndGetSet() {
		Date date = new Date(System.currentTimeMillis());
		Date dateNew = new Date(System.currentTimeMillis() + 60000L);
		User user = new User("WalterWhite", "pass", "a@a.de", UserGroup.NORMAL);
		Token tud = new Token(date, date, user);
		assertTrue(tud.getUser().equals(user));
		assertEquals(tud.getValidUntil(), date);
		assertEquals(tud.getCreatedOn(), date);
		tud.setCreatedOn(dateNew);
		tud.setValidUntil(dateNew);
		assertEquals(tud.getValidUntil(), dateNew);
		assertEquals(tud.getCreatedOn(), dateNew);
		assertTrue(tud.isActive());
		tud.setActive(false);
		assertFalse(tud.isActive());
		tud.setTokenString("blabla");
		assertEquals(tud.getTokenString(), "blabla");
		User userNew = new User("Thomas", "pass", "a@a.de", UserGroup.NORMAL);
		tud.setUser(userNew);
		assertTrue(tud.getUser().equals(userNew));
	}
}
