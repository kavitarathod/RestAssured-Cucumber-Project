package com.stepDefinitions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class StepDefinitions {
	private final static Logger logger = Logger.getLogger(StepDefinitions.class.getName());
	public static String apiEndPointUri;
	public static String testName;
	public static String CONTENT_TYPE;
	public static String STATUS_CODE;
	public static String FILE_PATH;
	public static String REQUESTBODY;
	public static String RESPONSEBODY;
	public static Response response;

	@Given("^I want to set URL as \"([^\"]*)\" for test case \"([^\"]*)\"$")
	public void setAPIEndpointURL(String URL, String testCaseName) {
		String apiHostName = "https://jsonplaceholder.typicode.com";
		apiEndPointUri = String.format("%s%s", apiHostName, URL);
		testName = testCaseName;
		logger.info("Cucumber Hostname URL is :: " + apiEndPointUri);
		logger.info("Cucumber Test case name is :: " + testName);
	}

	@When("^I set header content type as \"([^\"]*)\"$")
	public void setHeader(String contentType) {
		if (contentType != null && !contentType.isEmpty()) {
			CONTENT_TYPE = contentType;
			logger.info("Content type is :: " + CONTENT_TYPE);
		} else {
			logger.info("Content type cannot be null or empty!");
		}
	}

	@And("^I hit the API with requestbody \"([^\"]*)\" and request method is \"([^\"]*)\"$")
	public void submitRequest(String requestBodyPath, String requestType) throws Throwable {
		RestAssured.baseURI = apiEndPointUri;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", CONTENT_TYPE);
		if (requestBodyPath != null && !requestBodyPath.isEmpty() && requestType.equalsIgnoreCase("POST")
				|| requestType.equalsIgnoreCase("PUT")) {
			JSONParser jsonParser = new JSONParser();
			FILE_PATH = System.getProperty("user.dir") + "//src//main//java//" + requestBodyPath;
			logger.info("Path of requestbody file is :: " + FILE_PATH);
			try (FileReader reader = new FileReader(FILE_PATH)) {
				Object obj = jsonParser.parse(reader);
				REQUESTBODY = obj.toString();
				logger.info("Request Body is :: " + REQUESTBODY);
			} catch (FileNotFoundException | ParseException exc) {
				exc.printStackTrace();
			}
			if (REQUESTBODY.length() > 0) {
				request.body(REQUESTBODY);
				response = request.post();
			} else {
				
				logger.info(" Request Body cannot be null or empty!");
			}
		} else if (requestType.equalsIgnoreCase("GET")) {
			response = request.get();			
		}
		STATUS_CODE = String.valueOf(response.getStatusCode());
		RESPONSEBODY = response.getBody().asString();
	}
	
	@Then("^Verify the Response Time of the Request API$")
	public void verifyResponseTime(){	
		
		ValidatableResponse valRes = response.then();
		
		// Asserting response time is less than 2000 milliseconds		
		valRes.time(Matchers.lessThan(2000L));
		
	}

	@Then("^I try to verify the status code is \"([^\"]*)\"$")
	public void verifyStatusCode(String statusCode) {
		if (statusCode.equals(String.valueOf(STATUS_CODE))) {
			Assert.assertEquals(STATUS_CODE, statusCode);
			logger.info("Status Code is :: " + STATUS_CODE);
		} else {
			Assert.assertEquals(STATUS_CODE, statusCode);
			logger.info("Status Code is not as expected :: " + STATUS_CODE);
		}
	}

	@And("^I try to verify the response value \"([^\"]*)\" is \"([^\"]*)\"$")
	public void verifyResponseValue(String responseKey, String value) throws Throwable {
		JSONParser parser = new JSONParser();
		JSONObject responseObject = (JSONObject) parser.parse(RESPONSEBODY);
		Object key = (Object) responseObject.get(responseKey);
		compareResponseValues(String.valueOf(value), String.valueOf(key), responseKey);
	}

	@Then("^content type should be in \"([^\"]*)\" format$")
	public void content_type_should_be_in_format(String format) throws Throwable {
		String schemaPath = System.getProperty("user.dir") + "\\resources\\schema-json.json";
		System.out.print(schemaPath);

		if (format.equals("JSON")) {
			response.then().assertThat().contentType(ContentType.JSON).and()
					.body(matchesJsonSchemaInClasspath("schema-json.json"));
		}
	}

	private void compareResponseValues(String expected, String actual, String responseKey) {
		logger.info("Actual Value is  ::" + actual);
		logger.info("Expected Value is  ::" + expected);
		if (expected.equals(actual)) {
			Assert.assertEquals(actual, expected);
		} else {

			Assert.assertEquals(actual, expected);
		}
	}

}



