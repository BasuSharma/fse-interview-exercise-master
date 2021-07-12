package com.tradeledger.cards.services;

import com.tradeledger.cards.models.Applicant;
import com.tradeledger.cards.models.EligibilityResult;

public interface ApplicantEligibilityService {
	
	public abstract EligibilityResult checkApplicantEligibility(Applicant applicant);

}
