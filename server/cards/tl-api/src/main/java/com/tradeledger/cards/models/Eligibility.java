package com.tradeledger.cards.models;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Eligibility {



	@JsonProperty("eligibleCards")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private Set<String> eligibleCards;

	public Set<String> getEligibleCards() {
		return eligibleCards;
	}

	public void setEligibleCards(Set<String> eligibleCards) {
		this.eligibleCards = eligibleCards;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(eligibleCards);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eligibility other = (Eligibility) obj;
		return Objects.equals(eligibleCards, other.eligibleCards);
	}

	@Override
	public String toString() {
		return "Eligibility [eligibleCards=" + eligibleCards + "]";
	}
}
