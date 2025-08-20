package Api;

import Base.Basetest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GetApiCookies extends Basetest {

    @Test
    public void getApiCookies(){
        Response response = RestAssured.given()
                .cookie(sessionCookie.getName(),sessionCookie.getValue())
                .when().get("/pet/findByStatus?status=sold");

        assertEquals(response.getStatusCode(),200);
        System.out.println("GET Response:\n" + response.asPrettyString());
    }
}
