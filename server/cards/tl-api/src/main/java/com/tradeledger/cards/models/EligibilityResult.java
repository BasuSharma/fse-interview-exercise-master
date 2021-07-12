package com.tradeledger.cards.models;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EligibilityResult {



	@JsonFormat
	private Eligibility cards;

	public Eligibility getCards() {
		return cards;
	}

	public void setCards(Eligibility cards) {
		this.cards = cards;
	}

	@JsonCreator
	public EligibilityResult(Eligibility eligibility) {
		this.cards = eligibility;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EligibilityResult other = (EligibilityResult) obj;
		return Objects.equals(cards, other.cards);
	}
	
	@Override
	public String toString() {
		return "EligibilityResult [cards=" + cards + "]";
	}
	

}
