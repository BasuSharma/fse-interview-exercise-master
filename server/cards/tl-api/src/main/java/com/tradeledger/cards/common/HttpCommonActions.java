package com.tradeledger.cards.common;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HttpCommonActions {

	
	public static HttpHeaders getDefaultHTTPHeaderObject() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}
}
