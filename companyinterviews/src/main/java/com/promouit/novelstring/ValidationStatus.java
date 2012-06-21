package com.promouit.novelstring;

public enum ValidationStatus {
	VALID("Valid String"),
	INVALID_MINLENGHT(" length is less than minimun"), 
	INVALID_EXCEEDMAXLENGHT(" lenght exceeds the maximum 100");

	private String statusMessage;
	
	private ValidationStatus(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	@Override
	public String toString() {
		return statusMessage;
	}
}
