package com.tradeledger.cards.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tradeledger.cards.models.ErrorResposeEntity;

@ControllerAdvice
public class CardsApplicationHandler {

	@ExceptionHandler(value = EligibilityServiceAvailabilityException.class)
	public ResponseEntity<Object> exception(EligibilityServiceAvailabilityException exception) {

		return new ResponseEntity<>(
				new ErrorResposeEntity("Underlying Server Error", "Could not fetch results from Elibility service"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
