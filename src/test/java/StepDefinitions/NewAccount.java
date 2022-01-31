package StepDefinitions;

import Resources.APIResources;
import static org.junit.Assert.assertEquals;
import Resources.Reusable;
import Resources.TestDataBuild;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import pojo.AddAccountDto;
import pojo.AddProductDto;

import static io.restassured.RestAssured.*;

import java.io.IOException;


public class NewAccount extends Reusable{
	TestDataBuild data = new TestDataBuild();
	RequestSpecification r1;
	AddAccountDto aad;
	APIResources res;
	Response r2;
	String n;
	JsonPath jp;
	public static int aid;
	AddProductDto ad ;
	int id;
	public String pname;
	public String ano;
	

@Given("add account payload with {int},{string},{string}")
public void add_account_payload_with(Integer productId,String accountType,String accountNumber) throws IOException {

	r1= given().log().all().spec(requestData()).body(data.addaccountdata(productId, accountType, accountNumber));
	
	
}



@When("I hit {string} with post http request")
public void i_hit_with_post_http_request(String resource) {
	
	res = APIResources.valueOf(resource);
aad =r1.when().post(res.getResource()).as(AddAccountDto.class);

r2 = r1.when().post(res.getResource()).then().extract().response();


}

@Then("account should generated with statusCode {string}")
public void account_should_generated_with_status_code(String string) {

	aid = aad.getAccountDto().getAccountId();
	assertEquals(aad.getStatusCode(),string);
	id = aad.getAccountDto().getProductId();
	
	System.out.println("Account statuscode is:"+aad.getStatusCode());
	
	ano = aad.getAccountDto().getAccountNumber();
	System.out.println("Account no. is :"+ano);
	
}

@Then("message should displayed as {string}")
public void message_should_displayed_as(String string) {
assertEquals(aad.getMessage(),string);
	
	System.out.println("Message is:"+aad.getMessage());
}



@Given("get accounts url with {int},{string}")
public void get_accounts_url_with(Integer productId, String productName) throws IOException {

	
	r1 = given().log().all().spec(requestData())
			.body(" \n"
					+ "{  \"productId\": "+productId+",\n"
					+ "      \"productName\": \""+productName+"\"\n"
					+ "      \n"
					+ "}\n"
					+ "");

}
@When("I ran {string} with post http method")
public void i_ran_with_post_http_method(String resource) {
	
	res = APIResources.valueOf(resource);
r2 =r1.when().post(res.getResource());
}



@Then("accounts should generated with status Code {int}")
public void accounts_should_generated_with_status_code(Integer int1) {

	
	System.out.println("Status code is :"+r2.statusCode());
	
}


@Then("update status of account as {string} with Post method using {string}")
public void update_status_of_account_as_with_post_method_using(String string, String resource) throws IOException {

	res = APIResources.valueOf(resource);
	
	r1 = given().log().all().spec(requestData()).body(data.payloadUpdateAccount());
	
	String updatedres = r1.when().post(res.getResource()).then().log().all().extract().response().asString();
	
	System.out.println(updatedres);
	
	
}

@Then("same status maps to {string} using {string}")
public void same_status_maps_to_using(String string, String resource) throws IOException {
    
res = APIResources.valueOf(resource);
	
	r1 = given().log().all().spec(requestData());
	
	r1.when().get(res.getResource() +ano+"/productName/"+pname).then().log().all().assertThat().statusCode(200);


}

@Then("get productname using {string}")
public void get_productname_using(String resource) throws IOException {

	res = APIResources.valueOf(resource);
ad =given().log().all().spec(requestData()).when().get(res.getResource() + id).as(AddProductDto.class);
pname = ad.getProductDto().getProductName();
System.out.println("productname is :" +pname);
	

}


}
