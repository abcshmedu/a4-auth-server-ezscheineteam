package edu.hm.oauth.resources;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.Test;

import edu.hm.oauth.model.AuthData;
import edu.hm.oauth.model.User;
import edu.hm.oauth.model.UserGroup;

public class UsersResourceTest {

	UsersResource ur = new UsersResource();

	@Test
	public void testlistUsers() {
		User u = new User("testTest", "pw", "mail@mail.de", UserGroup.NORMAL);
		Response r = ur.createUser(u);
		assertEquals(200, r.getStatus());
		User uWrongMail = new User("testNewTest", "pw", "mailmail.de", UserGroup.NORMAL);
		Response rNew = ur.createUser(uWrongMail);
		assertEquals(400, rNew.getStatus());

		// conflict with existing user
		u = new User("testTest", "pw", "mail@mail.de", UserGroup.NORMAL);
		rNew = ur.createUser(u);
		assertEquals(409, rNew.getStatus());
	}

	@Test
	public void testGetUserData() {
		User u = new User("GetUserData", "pw", "mail@mail.de", UserGroup.NORMAL);
		ur.createUser(u);
		Response r = ur.getUserData("GetUserData");
		assertEquals(200, r.getStatus());
		r = ur.getUserData("notExisting");
		assertEquals(404, r.getStatus());
	}

	@Test
	public void testListUsers() {
		assertEquals(200, ur.listUsers().getStatus());
	}

	@Test
	public void testAuthenticateUser() {
		AuthData ta = new AuthData("","");
		Response r = ur.authenticateUser(ta);
		// User not existing
		assertEquals(404, r.getStatus());
		ta = new AuthData("WalterWhite", "d");
		r = ur.authenticateUser(ta);
		assertEquals(401, r.getStatus());
		ta = new AuthData("WalterWhite", "knockknock");
		r = ur.authenticateUser(ta);
		assertEquals(200, r.getStatus());
	}
	
	@Test
	public void testUpdateUser(){
		User u = new User("UpdateUserData", "pw", "mail@mail.de", UserGroup.NORMAL);
		Response r = ur.updateUser(u);
		// user not added to db
		assertEquals(404, r.getStatus());
		
		// add user to db
		ur.createUser(u);
		u = new User("UpdateUserData", "newpw", "mail@mail.de", UserGroup.NORMAL);
		r = ur.updateUser(u);
		assertEquals(200, r.getStatus());
	}
}
