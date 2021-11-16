package basicJunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicJunit {

    /**
     * setup / initialize / before
     */
    @BeforeEach
    public void setup(){
        System.out.println("setup ......");
    }

    /**
     * cleanup/ teardown / after
     */
    @AfterEach
    public void cleanup(){
        System.out.println("cleanup ......");
    }

    @Test
    public void verifyLoginOnFacebook(){
        System.out.println("Este es mi primer test");

    }

    @Test
    public void verifyLoginOnFacebook1(){
        System.out.println("Este es mi primer test");
    }

}
