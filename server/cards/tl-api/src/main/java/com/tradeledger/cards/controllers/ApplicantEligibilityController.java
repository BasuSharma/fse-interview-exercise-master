/**
 * 
 */
package com.tradeledger.cards.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tradeledger.cards.CardsApplication;
import com.tradeledger.cards.models.Applicant;
import com.tradeledger.cards.models.EligibilityResult;
import com.tradeledger.cards.services.ApplicantEligibilityService;

/**
 * @author Basu Sharma
 *
 */

@RestController
@RequestMapping("applicants")
public class ApplicantEligibilityController {

	/**
	 * Rest Controller  to check card related services including eligibility service from thirdparty application
	 * 
	 */
	@Autowired
	private ApplicantEligibilityService cardEligibilityService;
	static final Logger logger = 
	        (Logger) LoggerFactory.getLogger(ApplicantEligibilityController.class);

	@PostMapping(path = "cards", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	// Required only for local UIapp consumption
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<Object> checkCardEligibility(@RequestBody Applicant applicant) {
		logger.info("___________________ request received for _______________ "+ applicant.getName());
		EligibilityResult result = cardEligibilityService.checkApplicantEligibility(applicant);
		logger.info("____________________Generated Reponse______________"+ result.getCards().getEligibleCards().toString());
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
}
