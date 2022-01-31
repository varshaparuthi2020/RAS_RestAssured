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
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//
//public class ProductStepdefinition extends Utils {
//
//	Response response;
//	RequestSpecification req;
//	ResponseSpecification res;
//
//	// @Given("Add product payload")
//	// public void add_product_payload() throws IOException {
//
//	@Given("Add product payload with {string} {string} {string}")
//	public void add_product_payload_with(String productName, String status, String description) throws IOException {
//
//		TestDataBuild data = new TestDataBuild();
//
//		// usage of requestspec builder n responsespec builder
//
//		//res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
//		req = given().spec(requestSpecification()).body(data.createProductPayload(productName, status, description));
//
//	}
//
//	@When("user calls {string} with {string} http request")
//	public void user_calls_with_post_http_request(String resource, String method) {
//		// using enum concept calling endpoint
//		APIResources resourceAPI = APIResources.valueOf(resource);
//		System.out.println(resourceAPI.getResource());
//
//		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
//
//		//response = req.when().post(resourceAPI.getResource()).then().spec(res).extract().response();
//
//		// response = req.when().post("/products/addProduct").then().spec(res).extract().response();
//
//		if (method.equalsIgnoreCase("POST")) {
//			response = req.when().post(resourceAPI.getResource());
//
//		} else if (method.equalsIgnoreCase("GET")) {
//			response = req.when().get(resourceAPI.getResource());
//		}
//
//	}
//
//	@Then("the API got success with status code {int}")
//	public void the_api_got_success_with_status_code(Integer int1) {
//
//		System.out.println("expected resp is :" + response.getStatusCode());
//		assertEquals(response.getStatusCode(), 200);
//	}
//
//	@Then("{string} in response body is {string}")
//	public void in_response_body_is(String key, String value) {
//		// Write code here that turns the phrase above into concrete actions
//		String responsedata = response.asString();
//		JsonPath js = new JsonPath(responsedata);
//		assertEquals(js.get(key).toString(), value);
//		System.out.println(value);
//	}
////get product details 
//
//	@Given("get product api")
//	public void get_product_api() throws IOException {
//		TestDataBuild data = new TestDataBuild();
//
//		// usage of requestspec builder n responsespec builder
//
//		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
//
//		req = given().spec(requestSpecification());
//
//	}
//
//	@When("usr calls Get Api with Get http request")
//	public void usr_calls_get_api_with_get_http_request() {
//		response = req.when().get("/products").then().spec(res).extract().response();
//	}
//
//	@Then("thh API got succcess with status code {int}")
//	public void thh_api_got_succcess_with_status_code(Integer int1) {
//		System.out.println("expected resp is :" + response.getStatusCode());
//		assertEquals(response.getStatusCode(), 200);
//	}
//
//}
