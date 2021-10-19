package Task_15;

import Task_15.User.Root;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;


public class Task_15 {
    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in/";
    }

    @Test(dataProvider = "data")
    public void listUsers_test1(int integer) {
        String endpoint = "/api/users?id=" + integer;
        given().when().get(endpoint).then().statusCode(200);
        Root root = given().when().get(endpoint).getBody().as(Root.class);
        Assert.assertEquals(root.data.id, integer);
    }

    @Test
    public void singleUser_test2(){
        String endpoint = "/api/users?id=2";
        given().when().get(endpoint).then().statusCode(200);
        Root root = given().when().get(endpoint).as(Root.class);
        Assert.assertEquals(root.data.id, 2);
    }

    @Test
    public void singleUserNotFound_test3(){
        String endpoint = "/api/users?id=23";
        given().when().get(endpoint).then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void listResource_test4() {
        String endpoint = "/api/unknown";
        Assert.assertEquals(given().when().get(endpoint).then().statusCode(200).and().extract().jsonPath().getList("data").size(),6);
    }

    @Test
    public void singleResource_test5() {
        String endpoint = "/api/unknown/2";
        Assert.assertEquals(given().when().get(endpoint).then().statusCode(200).and().extract().jsonPath().getInt("data.id"),2);
    }

    @Test
    public void singleResourceNotFound_test6() {
        String endpoint = "/api/unknown/23";
        Assert.assertEquals(given().when().get(endpoint).getStatusCode(),404);
    }

    @Test
    public void create_test7() {
        String endpoint = "/api/users";
        String requestBody = readFileAsString("post");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "leader");
    }

    @Test
    public void update_test8() {
        String endpoint = "/api/users/2";
        String requestBody = readFileAsString("put");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().put(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
    }

    @Test
    public void update_2_test9() {
        String endpoint = "/api/users/2";
        String requestBody = readFileAsString("patch");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().patch(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident1");
    }

    @Test
    public void delete_test10() {
        String endpoint = "/api/users/2";
        Response response = given().delete(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 204);
    }

    @Test
    public void registerSuccessful_test11() {
        String endpoint = "/api/register";
        String requestBody = readFileAsString("register");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
    }

    @Test
    public void registerUnsuccessful_test12() {
        String endpoint = "/api/register";
        String requestBody = readFileAsString("registerUnsuccessful");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");
    }

    @Test
    public void loginSuccessful_test13() {
        String endpoint = "/api/login";
        String requestBody = readFileAsString("loginSuccessful");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
    }

    @Test
    public void loginUnsuccessful_test14() {
        String endpoint = "/api/login";
        String requestBody = readFileAsString("loginUnsuccessful");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");
    }

    @Test
    public void delayedResponse_test15() {
        String endpoint = "/api/users?delay=3";
        Assert.assertEquals(given().when().get(endpoint).then().statusCode(200).and().extract().jsonPath().getList("data").size(),6);
    }


    @DataProvider(parallel = true)
    public Object[][] data() {
        return new Object[][]{
                {7},
                {8},
                {9},
                {10},
                {11},
                {12}
        };
    }

    public static String readFileAsString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Task_15/requests/" + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
