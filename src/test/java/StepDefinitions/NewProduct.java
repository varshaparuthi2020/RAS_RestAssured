package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import Resources.APIResources;
import Resources.Reusable;
import Resources.TestDataBuild;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddProductDto;

public class NewProduct extends Reusable {
	RequestSpecification r1;
	Response resp;
	AddProductDto ad;
	TestDataBuild data = new TestDataBuild();
	int pid;
	APIResources res;
	String n;

	@Given("Add product payload with {string} {string} {string}")
	public void add_product_payload_with(String productName, String status, String description) throws IOException {
		r1 = given().spec(requestData()).body(data.createProductPayload(productName, status, description));

	}
	

	@When("I hit {string} http request with POST method")
	public void i_hit_http_request_with_post_method(String resource) {

		res = APIResources.valueOf(resource);
		ad = r1.when().post(res.getResource()).as(AddProductDto.class);
		
		

	}

	/*
	 * @Then("{string} in response body got {string}") public void
	 * in_response_body_got(String string, String string2) {
	 * 
	 * assertEquals(ad.getStatusCode(), 200);
	 * System.out.println("status code is: "+ad.getStatusCode());
	 * 
	 * }
	 */

	@Then("the API give Success")
	public void the_api_give_success() {

		// assertEquals(ad.getStatusCode());
		System.out.println("status code is: " + ad.getStatusCode());
		pid = ad.getProductDto().getProductId();
		System.out.println("Productid is " + ad.getProductDto().getProductId());
		String actualmsg = ad.getMessage();
		System.out.println("Message is :" + actualmsg);
		// assertEquals(actualmsg,key);

	}

	@Then("same productName maps to productName using {string}")
	public void same_product_name_maps_to_product_name_using(String resource) {
		res = APIResources.valueOf(resource);

		Response name = r1.when().get(res.getResource() + pid).then().log().all().extract().response();
		String n = name.asString();
		JsonPath j1 = new JsonPath(n);
		System.out.println(j1.get("status"));
		System.out.println(j1.get("productName"));

	}

	@When("I hit {string} http request with Get method")
	public void i_hit_http_request_with_get_method(String resource) throws IOException {
		res = APIResources.valueOf(resource);

		resp = given().spec(requestData()).when().get(res.getResource()).then().assertThat().statusCode(200).extract()
				.response();

	}

	@Then("the {string} in response give {string}")
	public void the_in_response_give(String key, String val) {

		String s = resp.asString();
		JsonPath j = new JsonPath(s);
		assertEquals(j.get(key).toString(), val);

		System.out.println("status is:" + resp.asString());

	}

	@Then("update status of product as Inactive with Post method using {string}")
	public void update_status_of_product_as_inactive_with_post_method_using(String resource)
			throws IOException {
		res = APIResources.valueOf(resource);

		given().spec(requestData())
				.body("{\n" + "        \"productId\": " + pid + ",\n" + "        \"status\": \"INACTIVE\"   \n" + "}")
				.when().post(res.getResource()).then().assertThat().statusCode(200);
	}

	@Then("update configuration of product with Post method using {string}")
	public void update_configuration_of_product_with_post_method_using(String resource) throws IOException {
		res = APIResources.valueOf(resource);

		String stri = given().spec(requestData())
				.body("{\n" + "\"productId\": " + pid + ",\n" + "\"productName\": \""
						+ ad.getProductDto().getProductId() + "\",\n" + "\"productConfigDtoList\": [\n" + "{\n"
						+ "\"configName\": \"Rate_Limit\",\n" + "\"configValue\": \"1001\",\n"
						+ "\"status\": \"ACTIVE\",\n" + "\"createdBy\": \"Seema\"\n" + "},\n" + "{\n"
						+ "\"configName\": \"ALLOW_NEGATIVE_BALANCE\",\n" + "\"configValue\": \"700\",\n"
						+ "\"status\": \"INACTIVE\",\n" + "\"createdBy\": \"Varsha\"\n" + "}\n" + "]\n" + "   }")
				.when().post(res.getResource()).then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Updated config is :" + stri);

	}

}
