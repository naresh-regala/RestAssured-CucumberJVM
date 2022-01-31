package gradle.cucumber;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.junit.Assert;

import RestAssured.CucumberJVM.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition {
	RequestSpecification req;
	Response resp;
	User user;
	String id;
	String UID;
	String useremail;
	HashMap<String, Object> map;
	String baseURI;

	@Given("Api baseURI and USERID {string}")
	public void api_base_uri_and_userid(String USERID) {
		UID = USERID;
		req = given().baseUri(System.getProperty("baseURI")).pathParam("UID", USERID);
	}

	@When("user request user details using USERID")
	public void user_request_user_details_using_userid() {
		resp = req.when().get("/users/{UID}");
	}

	@Then("user api should be responded with {string}")
	public void user_details_should_be_responded_with(String expected) {
		String actual = Integer.toString(resp.getStatusCode());
		Assert.assertEquals(expected, actual);
	}

	@Then("USERID should match with id in the Reponse")
	public void userid_should_match_with_id_in_the_reponse() {
		user = resp.getBody().as(User.class);
		String actualUid = Integer.toString(user.getData().getId());
		Assert.assertEquals(UID, actualUid);
	}

	@Then("useremail should be {string}")
	public void useremail_should_be(String email) {
		useremail = email;
		String actualEmail = user.getData().getEmail();
		Assert.assertEquals(useremail, actualEmail);
	}
	
	@Given("Api baseURI and name {string} and job {string}")
	public void api_base_uri_and_name_and_job(String NAME, String JOB) {
		map = new HashMap<String, Object>();
		map.put("name", NAME);
		map.put("job", JOB);
		map.put("email", "test1@gmail.com");
		req = given().baseUri(System.getProperty("baseURI")).log().all();
	}

	@When("create user api is called")
	public void create_user_api_is_called() {
		resp = req.body(map).when().post("/users");
	}

}
