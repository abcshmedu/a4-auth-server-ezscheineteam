package edu.hm.oauth.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthDataTest {

	@Test
	public void testConstructorAndSetGet(){
		AuthData ad = new AuthData("name", "password");
		assertEquals(ad.getPassword(),"password");
		assertEquals(ad.getName(),"name");
		ad.setName("newname");
		ad.setPassword("newpass");
		assertEquals(ad.getPassword(),"newpass");
		assertEquals(ad.getName(),"newname");
	}
}
