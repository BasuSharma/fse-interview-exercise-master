package com.tradeledger.cards.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import com.tradeledger.cards.CardsApplication;
import com.tradeledger.cards.common.HttpCommonActions;
import com.tradeledger.cards.exceptions.EligibilityServiceAvailabilityException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tradeledger.cards.models.Applicant;
import com.tradeledger.cards.models.EligibilityResult;
import com.tradeledger.cards.services.ApplicantEligibilityService;

@Service
public class ApplicantEligibilityServiceImpl implements ApplicantEligibilityService {

	@Autowired
	public RestTemplate restTemplate;
	
	private static final String url = "http://localhost:3317/eligibility/check";
	static final Logger logger = 
	        (Logger) LoggerFactory.getLogger(ApplicantEligibilityServiceImpl.class);
	
	
	/**
	 * Service method to call eligibility check service from third party Rest api provider
	 */
			
	@Override
	public EligibilityResult checkApplicantEligibility(Applicant applicant) {
		HttpHeaders headers = HttpCommonActions.getDefaultHTTPHeaderObject();
		HttpEntity<Applicant> requestEntity = new HttpEntity<Applicant>(applicant, headers);
		try {
			logger.info("Sending request to Third Party API");
			EligibilityResult eligibilityResult = restTemplate.exchange(url,
					HttpMethod.POST, requestEntity, EligibilityResult.class).getBody();
			return eligibilityResult;
		} catch (Exception e) {
			logger.error("Error occurred in calling external third party api : Eligibility -" , e);
			throw new EligibilityServiceAvailabilityException();
		}

	}

}
