package com.amazon.libs;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class APICommons extends ActionEngine{
    RequestSpecification httpRequest;
    Response response;
    int statusCode;

    @BeforeClass
    //Setting the baseURI from Properties file
    public void setBaseUri () {
        RestAssured.baseURI = prop.getBaseURI();
    }

    /*
     * This method verify the GET-Emp Status code
     * Response value "staus"
     * Resource passed from properties file
     */

    public void verifyEmp_GET(){
        statusCodeValidation(200,prop.getEmp());
        respValueValidation("status","status",prop.getEmp());
    }
    /*
     * This method verify theDELETE-Emp Status code
     * Response value message
     * Resource passed from properties file
     */
    public void verifyEmp_DELETE(){
        statusCodeValidation(200,prop.deleteEmp());
        deleteEmp(prop.deleteEmp());
    }

    //Status code validation
    public void statusCodeValidation (int expStatusCode,String resource) {
        httpRequest = RestAssured.given();
        response = httpRequest.get(resource);
        statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode , expStatusCode , "Status code to be Successful");
    }
    //Response Value
    public void respValueValidation (String respPath,String respValue,String resource) {
        httpRequest = RestAssured.given();
        response = httpRequest.get(resource);
        JsonPath jsonPathEvaluator = response.jsonPath();
        String jsonPathValue = jsonPathEvaluator.get(respPath);
        System.out.println("Success received from Response " + jsonPathValue);

        // Validate the response//
        Assert.assertEquals(jsonPathValue, respValue, "Correct Response value received in the Response");
    }

    //Delete Employee
    public void deleteEmp (String resource) {
        httpRequest = RestAssured.given();
        response = httpRequest.get(resource);
        JsonPath jsonPathEvaluator = response.jsonPath();
        String jsonPathValue = jsonPathEvaluator.get("message");
        System.out.println("Success received from Response " + jsonPathValue);

        // Validate the response//
        Assert.assertEquals(jsonPathValue, "successfully! deleted Records");
    }

}
