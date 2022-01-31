//package StepDefinitions;
//
//import static io.restassured.RestAssured.given;
//import static org.junit.Assert.assertEquals;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import Resources.APIResources;
//import Resources.TestDataBuild;
//import Resources.Utils;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBodyExtractionOptions;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//import pojo.AddProductDto;
//import pojo.AddProductPayload;
//
//
//public class E2E_ProductStepDefinition extends Utils {
//
//	Response response;
//AddProductDto ad = new AddProductDto();
//	AddProductPayload pdt = new AddProductPayload();
//	RequestSpecification req;
//	ResponseSpecification res;
//	TestDataBuild data = new TestDataBuild();
//	static int prod_id;
//	
//	
//
//	@Given("Add product payload with {string} {string} {string}")
//	public void add_product_payload_with(String productName, String status, String description) throws IOException {
//		
//		req= given().spec(requestSpecification()).body(data.createProductPayload(productName, status, description));
//
//				//req = given().spec(requestSpecification()).body(data.createProductPayload(productName, status, description));
//
//	}
//
//	@When("user calls {string} with {string} http request")
//	public void user_calls_with_http_request(String resource, String method) throws IOException {
//		APIResources resourceAPI = APIResources.valueOf(resource);
//		System.out.println(resourceAPI.getResource());
//
//		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
//		 prod_id = ad.getProductDto().getProductId();
//
//		if (method.equalsIgnoreCase("POST")) {
//			response = req.when().post(resourceAPI.getResource());
//
//			 ad =response.as(AddProductDto.class);
//		} 
//		else if (method.equalsIgnoreCase("GET")) {
//			 prod_id = ad.getProductDto().getProductId();
//			response = req.when().get(resourceAPI.getResource()+prod_id);
//			 ad =response.as(AddProductDto.class);
//			
//		System.out.println(ad);
//		}
//
//	}
//
//	@Then("the API got success with status code {int}")
//	public void the_api_got_success_with_status_code(Integer int1) {
//		System.out.println("expected resp is :" + response.getStatusCode());
//		assertEquals(response.getStatusCode(), 200);
//
//	}
//
//	@Then("{string} in response body is {string}")
//	public void in_response_body_is(String key, String value) {
//		assertEquals(getJsonPath(response, key), value);
//		
//		System.out.println(value);
//
//
//	}
//
//	@Then("verify productName created maps to {string} using {string}")
//	public void verify_product_Name_created_maps_to_using(String expectedval, String resource) throws IOException {
//
//		 		req= given().spec(requestSpecification());
//		 		
//		user_calls_with_http_request(resource, "GET");
//
//		//String actproductName = getJsonPath(response,"productName");
//		//System.out.println("Prod id is :"+ad.getProductDto().getProductId());
//		
//		//System.out.println("Actual val:" + actproductName);
//		//System.out.println("Expected val:" + expectedval);
//
//	}
//
//}
