package testClean;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import singletonSession.Session;

public class TestBase {
    @BeforeEach
    public void setup(){
        Session.getInstance().getDriver().get("http://todo.ly/");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeSession();
    }
}
