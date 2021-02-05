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
        verifyEmp_GET();
    }

    @Test
    public void deleteEmpValidation(){
        verifyEmp_DELETE();
    }

}
