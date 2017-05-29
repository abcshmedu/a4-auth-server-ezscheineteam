package edu.hm.oauth.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;
import edu.hm.oauth.model.UserGroup;

public class TokenRepositoryStubTest {

	TokenRepositoryStub stub = new TokenRepositoryStub();
	User u = new User("test","test","test@test.de", UserGroup.NORMAL);
	
	@Test
	public void testTokenGenerating(){
		User u = new User("test","test","test@test.de", UserGroup.NORMAL);
		Token t = stub.generateToken(u);
		Token t2 = stub.generateToken(u);
		assertEquals(u,t.getUser());
		assertEquals(stub.validateToken(t2.getTokenString()), t2);
		assertNull(stub.validateToken("testTokenNotExisting"));		
	}
	
	@Test
	public void testDeleteToken(){
		Token t = stub.generateToken(u);
		assertTrue(stub.deleteToken(t));
		assertFalse(stub.deleteToken(t));
	}
}
