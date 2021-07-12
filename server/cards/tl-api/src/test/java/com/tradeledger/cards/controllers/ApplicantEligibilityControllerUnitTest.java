package com.tradeledger.cards.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradeledger.cards.CardsApplication;
import com.tradeledger.cards.models.Applicant;
import com.tradeledger.cards.models.Eligibility;
import com.tradeledger.cards.models.EligibilityResult;
import com.tradeledger.cards.services.ApplicantEligibilityService;




@RunWith(SpringRunner.class)
@ActiveProfiles("Junit")
@WebMvcTest
class ApplicantEligibilityControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
    @MockBean
    private ApplicantEligibilityService applicantEligibilityService;
    

	@Autowired
	public RestTemplate restTemplate;

	private static ObjectMapper mapper = new ObjectMapper();
	
    @Test
    public void testPostMethodOfController() throws Exception {
    	Applicant applicant = new Applicant("Boris","Boris@gmail.com", "Boris address");
    	Eligibility eligibility = new Eligibility();
    	Set<String> card_list =  new HashSet<String>(2);
    	card_list.add("C1"); 
    	eligibility.setEligibleCards(card_list);
    	EligibilityResult eligibilityResult = new EligibilityResult(eligibility);
    	
        Mockito.when(applicantEligibilityService.checkApplicantEligibility(ArgumentMatchers.any())).thenReturn(eligibilityResult);
        String json = mapper.writeValueAsString(applicant);
        mockMvc.perform(post("/applicants/cards").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.cards.eligibleCards[0]", Matchers.equalTo("C1")));
    }
 
   
    
}
