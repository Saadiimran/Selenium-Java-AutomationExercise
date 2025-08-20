package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class CreateUpdateDeleteTest {
    @Test
    public void CompleteAPITest(){
        String jsonpayload = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

        Response response = RestAssured.given()
                .baseUri("https://reqres.in")
                .header("Content-Type","application/json")
                .header("x-api-key","reqres-free-v1")
                .body(jsonpayload).when().post("/api/users");

        assertEquals(response.getStatusCode(),201);
        String userid = response.jsonPath().getString("id");
        assertNotNull(userid);

        System.out.println("POST Response:\n" + response.asPrettyString());


        String updatepayload = "{\"name\": \"morpheus\",\"job\": \"genz-leader\"}";

        Response response1 = RestAssured.given()
                .baseUri("https://reqres.in")
                .header("Content-Type","application/json")
                .header("x-api-key","reqres-free-v1")
                .body(updatepayload).when().put("/api/users/" + userid);

        assertEquals(response1.getStatusCode(),200);
        System.out.println("PUT Response:\n" + response1.asPrettyString());
    }
}
