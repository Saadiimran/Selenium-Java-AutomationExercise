package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class GetSingleUserTest {

    @Test
    public void testGetSingleUser(){
        Response response = RestAssured.given()
                .baseUri("https://reqres.in")
                .when().get("/api/users/2");

        assertEquals(response.getStatusCode(),200);
        String email = response.jsonPath().getString("data.email");
        assertTrue(email.endsWith("@reqres.in"));

        System.out.println("GET Response:\n" + response.asPrettyString());
    }
}
