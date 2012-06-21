package com.promouit.novelstring;

public enum StringAnalysisStatus {
	NOVEL_STRING(" is a Novel String"), 
	NOT_NOVEL_STRING(" is not a Novel String");
	
	private String statusMessage;

	private StringAnalysisStatus(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	@Override
	public String toString() {
		return statusMessage;
	}
	
}
