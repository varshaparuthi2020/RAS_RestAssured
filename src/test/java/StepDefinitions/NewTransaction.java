package StepDefinitions;

import Resources.APIResources;
import Resources.Reusable;
import Resources.TestDataBuild;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AddTransactionDto;

import static io.restassured.RestAssured.*;

import java.io.IOException;


public class NewTransaction extends Reusable{
	TestDataBuild data = new TestDataBuild();
	APIResources res;
	RequestSpecification r1;
	AddTransactionDto at;	
		int loanaccountId ;
	int poolaccountid;

@Given("create Transaction payload with {int},{int},{int}")
public void create_transaction_payload_with(Integer toAccountId, Integer productId, Integer amount) throws IOException {
r1= given().log().all().spec(requestData()).body(data.addTransactionBalance(toAccountId, productId, amount));	
	
}


@Given("create Transaction payload with {int}, {int}, {int} , {int}")
public void create_transaction_payload_with(Integer fromAccountId, Integer toAccountId, Integer productId, Integer amount) throws IOException {
    // Write code here that turns the phrase above into concrete actions
	
	
	r1= given().log().all().spec(requestData()).body(data.addTransaction(fromAccountId,toAccountId, productId, amount));

}



	@When("I run {string} with post http request")
	public void i_run_with_post_http_request(String resource) {

		res = APIResources.valueOf(resource);
		at =r1.when().post(res.getResource()).as(AddTransactionDto.class);
		
		
	}

	@Then("statusCode should be {string}")
	public void status_code_should_be(String string) {
loanaccountId = at.getTransactionDto().getToAccountId();
//poolaccountid = at.getTransactionDto().getFromAccountId();
//System.out.println("loan id :"+loanaccountId+ "Pool id is :" +poolaccountid );


		
		System.out.print("transaction api status code is : "+at.getStatusCode());
	}


	@Then("fetch balance using {string}")
	public void fetch_balance_using_for(String resource) throws IOException {
		res = APIResources.valueOf(resource);
		r1= given().log().all().spec(requestData()).body("{\n"
				+ "    \"accountId\": " +loanaccountId + " \n"				+ "}");
		String bal= r1.when().post(res.getResource()).then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.print("Account balanceAPI response :"+bal);
		
	}

	@Then("fetch ledger details using {string}")
	public void fetch_ledger_details_using(String resource) throws IOException {
		res = APIResources.valueOf(resource);
		r1= given().log().all().spec(requestData()).body("{\n"
				+ "    \"accountId\": " +loanaccountId + " \n"				+ "}");
		
String led= r1.when().post(res.getResource()).then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.print("Account ledgerAPI response :"+led);

	}


	
	
	
}
