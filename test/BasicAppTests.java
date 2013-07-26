import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;



public class BasicAppTests {

    @Test 
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }
    
    @Test
    public void testLogin() {
    	running(fakeApplication(), new Runnable() {
    		public void run() {
                Result result = callAction(controllers.routes.ref.Application.index());

                assertThat(status(result)).isEqualTo(OK);
                assertThat(contentAsString(result)).contains("This is the websockets demo");
                
                // Log in as Station 1
                Result room1 = callAction(controllers.routes.ref.Application.chatRoom("1"));
                assertThat(contentAsString(room1)).contains("STATION 1");
                
             // Log in as Station 1
                Result room2 = callAction(controllers.routes.ref.Application.chatRoom("2"));
                assertThat(contentAsString(room2)).contains("STATION 2");
            }
    		
    	});
    }

}