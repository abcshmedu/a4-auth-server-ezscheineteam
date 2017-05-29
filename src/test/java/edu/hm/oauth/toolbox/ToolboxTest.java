package edu.hm.oauth.toolbox;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToolboxTest {

	@Test
	public void testTokenLength(){
		// at least 20 characters long
		assertTrue(Toolbox.nextToken().length() > 20);
	} 
	
	@Test
	public void testNextIDcounter(){
		int count = Toolbox.nextID();
		assertTrue(count == 1);
		count = Toolbox.nextID();
		assertTrue(count == 2);
		count = Toolbox.nextID();
		assertTrue(count == 3);
		count = Toolbox.nextID();
		assertTrue(count == 4);
	}
	
	@Test
	public void testValidateEmail(){
		assertTrue(Toolbox.validateEmail("martin@martin.de"));
		assertTrue(Toolbox.validateEmail("m___@martin.de"));
		assertTrue(Toolbox.validateEmail("mn.nm@martin.de"));
		assertFalse(Toolbox.validateEmail("mn.nmmartin.de"));
		assertFalse(Toolbox.validateEmail("mn.nm@martinde"));
		assertFalse(Toolbox.validateEmail("123ämn.nmmartin.de"));
		assertFalse(Toolbox.validateEmail(".mn.nm²@martin.de"));
	}
	
	@Test
	public void testToString(){
		assertEquals("{ \"fieldname\" : \"fieldvalue\"}",Toolbox.stringToJson("fieldname", "fieldvalue"));		
	}
	
}
