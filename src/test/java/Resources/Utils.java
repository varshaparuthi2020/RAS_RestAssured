package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AddProductDto;
import pojo.ProductDto;

public class Utils extends AddProductDto{

	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		// RestAssured.baseURI = "http://localhost:8090";

		
		if(req==null) {
		PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));

		req = new RequestSpecBuilder().setBaseUri(getGlobalvalues("baseUrl")).setContentType(ContentType.JSON)
				// .addHeader("x-consumer-profile", "varsha")
				// add logs of request/response into one file
				.addFilter(RequestLoggingFilter.logRequestTo(stream))
				.addFilter(ResponseLoggingFilter.logResponseTo(stream)).build();

		return req;
	}
		return req;
	}

	public static String getGlobalvalues(String key) throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream("/Users//varsha.cn//eclipse-workspace//RAS_RestAssured//src//test//java//Resources//global.properties");

		prop.load(fis);

		// prop.getProperty("baseurl");

		return prop.getProperty(key);

	}
	
	public  String getJsonPath(Response response , String key) {
		
		String responsedata = response.asString();
		 JsonPath js = new JsonPath(responsedata);
		 return js.get(key);

			 
				 }
	
public static int getJsonPathnew(Response response , String key) {
		
		String responsdata = response.asString();
		 JsonPath js1 = new JsonPath(responsdata);
return js1.getInt(responsdata);


			 
				 }

	
	}

