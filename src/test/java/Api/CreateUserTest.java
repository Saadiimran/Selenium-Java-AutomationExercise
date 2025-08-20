package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CreateUserTest {

    @Test
    public void createUser(){
        String jsonPayload = "{\"name\": \"morpheus\", \"job\": \"leader\"}";

        Response response = RestAssured.given().baseUri("https://reqres.in")
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1")
                .body(jsonPayload).when().post("/api/users");

        assertEquals(response.getStatusCode(),201);
        assertEquals(response.jsonPath().getString("name"),"morphues");

        System.out.println("POST Response:\n" + response.asPrettyString());
    }
}
