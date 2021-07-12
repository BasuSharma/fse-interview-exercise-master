package com.tradeledger.cards.controllers;
import static io.restassured.RestAssured.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradeledger.cards.CardsApplication;
import com.tradeledger.cards.common.HttpCommonActions;
import com.tradeledger.cards.exceptions.EligibilityServiceAvailabilityException;
import com.tradeledger.cards.models.Applicant;
import com.tradeledger.cards.models.EligibilityResult;

import io.restassured.RestAssured;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= CardsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("Junit")
public class ApplicantEligibilityIntegrationTest {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@LocalServerPort
	private int port;
	
	@Before
	public void setUp() throws Exception {
	    RestAssured.port = port;
	}
	
	
	// Below test will fail when eligibility server api is up and running
	
	@Test
	public void postApplicantRequestTest() throws Exception {
	
    	Applicant applicant = new Applicant("Boris","Boris@gmail.com", "Boris address");
		String json = mapper.writeValueAsString(applicant);
		   given()
		       .body(json)
		       .header("Content-Type", "application/json")
		       .when().post("/applicants/cards")
		       .then().assertThat().statusCode(500);
		}

	
	
}
