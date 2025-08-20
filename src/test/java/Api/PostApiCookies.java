package Api;

import Base.Basetest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PostApiCookies extends Basetest {

    @Test
    public void PostApi(){
        JSONObject postParam = new JSONObject();
        postParam.put("id","1234");
        postParam.put("name","snowy");
        postParam.put("status","sold");


        Response response = RestAssured.given()
                .cookie(sessionCookie.getName(),sessionCookie.getValue())
                .contentType("application/json")
                .body(postParam.toString())
                .when().post("/pet");

        assertEquals(response.getStatusCode(),201);
        System.out.println("POST Response:\n" + response.asPrettyString());
    }


}
