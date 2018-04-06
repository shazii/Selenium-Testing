package com.example.esc_project_tests;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * Created by Shameena on 5/4/2018.
 */

public class POST_CourseCreate {

    @Test
    public void CourseCreatePOST() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://smartclass-backend.herokuapp.com/course";


        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification request = given();

//        Map<String, Object> map = new HashMap<>();
//        map.put("courseId", "50.003");
//        map.put("courseName", "Testss");
//        map.put("description", "elements");

        JSONObject requestParams = new JSONObject();
        requestParams.put("courseId", "90.908"); // Cast
        requestParams.put("courseName", "testing");
        requestParams.put("description", "Something");

        request.header("Content-Type", "application/json");
        //request.body(requestParams.toString());
        Response response = request.post("/create");
        ResponseBody body =
                given().
                        accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("Content-Tye", "application/json").
                        body(requestParams).
                        when().
                        post("/course/create").
                        thenReturn().body();
        Assert.assertNotNull(body);

        int statusCode = response.getStatusCode();
        assertEquals( statusCode, 200);
//        String successCode = response.jsonPath().get("SuccessCode");
//        Assert.assertEquals("Correct Success code was returned", "OPERATION_SUCCESS", successCode);
//        given().when().get("/course/create").then().body(containsString("testing"));

    }

    @Test
    public void CourseReadGET(){
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://smartclass-backend.herokuapp.com";

        RequestSpecification request = given();
        Response response = request.get("/course");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();

        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        String bodyAsString = body.asString();
        JsonPath jsonPathEvaluator = response.jsonPath();

        ResponseBody body1 =
                given().
                        accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("Content-Tye", "application/json").
                        when().
                        get("/course").
                        thenReturn().body();
        Assert.assertNotNull(body1);
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200);
    }

    @Test
    public void CourseDelete(){
        RestAssured.baseURI = "https://smartclass-backend.herokuapp.com/course/delete";

        RequestSpecification request = given();
        Response response = request.delete("/course/delete");
    }

    @Test
    public void LectureCreate(){
        RestAssured.baseURI = "https://smartclass-backend.herokuapp.com/lecture/create";

        RequestSpecification request = given();
        Response response = request.post("/lecture/create");
    }


    @Test
    public void LectureRead(){
        RestAssured.baseURI = "https://smartclass-backend.herokuapp.com/lecture";

        RequestSpecification request = given();
        Response response = request.get("/lecture");
    }

    @Test
    public void LectureDelete(){ RestAssured.baseURI = "https://smartclass-backend.herokuapp.com/lecture/delete";

        RequestSpecification request = given();
        Response response = request.get("/lecture/delete");
    }
}



