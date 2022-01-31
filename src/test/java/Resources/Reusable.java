package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.AddProductDto;

public class Reusable extends AddProductDto{

	
	RequestSpecification r1;
	PrintStream ps;
	public RequestSpecification requestData() throws IOException {
		
		
	if(r1==null){
		 ps = new PrintStream(new FileOutputStream(new File("Logsupdated.txt"),true));
		 
		return r1= new RequestSpecBuilder().setBaseUri(getGlobalvalues("baseUrl")).setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(ps))
				.addFilter(ResponseLoggingFilter.logResponseTo(ps))
				.build();

	}
	return r1;
	}
	
	public static String getGlobalvalues(String key) throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream("/Users//varsha.cn//eclipse-workspace//RAS_RestAssured//src//test//java//Resources//global.properties");

		prop.load(fis);

		// prop.getProperty("baseurl");

		return prop.getProperty(key);

	}

}
