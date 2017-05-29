package edu.hm.oauth.resources;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.junit.Test;

import edu.hm.oauth.model.AuthData;
import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;
import edu.hm.oauth.model.UserGroup;

public class CheckResourceTest {

	private CheckResource cr = new CheckResource();
	private UsersResource ur = new UsersResource();

	@Test
	public void testCheckResource() {
		Response r = cr.checkToken("");
		assertEquals(404, r.getStatus());
		User u = new User("CheckResource", "pw", "mail@mail.de", UserGroup.NORMAL);
		r = ur.createUser(u);
		assertEquals(200, r.getStatus());
		r = ur.authenticateUser(new AuthData("CheckResource", "pw"));
		assertEquals(200, r.getStatus());
		JSONObject json = new JSONObject((String)r.getEntity());
		String tokenString = json.getString("token");
		r = cr.checkToken(tokenString);
		assertEquals(200, r.getStatus());
		r = cr.checkToken("falseToken");
		assertEquals(404, r.getStatus());
	}
}
