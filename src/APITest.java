import java.util.Map;

import javax.xml.ws.Response;

import play.libs.WS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;

import okhttp3.OkHttpClient;

public class APITest {
	
	static String url = "https://dummy.restapiexample.com/api/v1";
	static String employeeNumber = null;

	public static void getRequest() {
		
		OkHttpClient client = new Request.Builder().get().url(url).build();
		Response response = null;
		response = client.newCall(request).execute();
		String jsonResponse = response().body().string();
		System.out.println(jsonResponse);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		JSONObject jsonobj = new JSONObject(jsonResponse);
		int employeeID = (int) jsonobj.get("employeeID");
		employeeNumber = String.valueOf(employeeID);
		System.out.println(employeeNumber);
	}
	
	public static void deleteRequest() {
		
	    RequestSpecification request = RestAssured.given();
	    Response response = request.delete("/delete/"+ employeeNumber);
	    int statusCode = response.getStatusCode();
	    System.out.println(response.asString());
	    Assert.assertEquals(statusCode, 200);    		
	    String jsonString =response.asString();
	    Assert.assertEquals(jsonString.contains("Deleted successfully"), true);	
	}

}
