package edu.hm.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import edu.hm.oauth.model.AuthDataTest;
import edu.hm.oauth.model.TokenTest;
import edu.hm.oauth.model.UserTest;
import edu.hm.oauth.toolbox.ToolboxTest;

//CHECKSTYLE:OFF:
@RunWith(Suite.class)
//CHECKSTYLE:ON:
@Suite.SuiteClasses({ ToolboxTest.class, AuthDataTest.class, TokenTest.class, UserTest.class })
@SuppressWarnings("JavadocMethod")
public class OauthTestSuite {

    public static final String APP_URL = "/";
    public static final int PORT = 80;
    public static final String WEBAPP_DIR = "./src/main/webapp/";
    private static Server jetty;
  

    @BeforeClass
    public static void setUp() {
        jetty = new Server(PORT);
        jetty.setHandler(new WebAppContext(WEBAPP_DIR, APP_URL));
        try {
            jetty.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown() {
        try {
            jetty.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
