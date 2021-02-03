package com.amazon.scripts;

import com.amazon.libs.APICommons;
import com.amazon.utilities.PropertyFileReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_Employee extends APICommons {
    PropertyFileReader prop = new PropertyFileReader();
    String baseUri = prop.getBaseURI().toString();

    @Test
    public void getEmpValidation(){
        statusCodeValidation(200,"/api/v1/employee/10");
        respValueValidation("status","status","/api/v1/employee/10");
    }

    @Test
    public void deleteEmpValidation(){
        statusCodeValidation(200,"/api/v1/delete/2");
        respValueValidation("status","status","/api/v1/delete/2");
    }

}
