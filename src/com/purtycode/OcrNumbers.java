package com.purtycode;

public enum OcrNumbers {
	ZERO  (" _ | ||_|", 0),
	ONE   ("     |  |", 1),
	TWO   (" _  _||_ ", 2),
	THREE (" _  _| _|", 3),
	FOUR  ("   |_|  |", 4),
	FIVE  (" _ |_  _|", 5),
	SIX	  (" _ |_ |_|", 6),
	SEVEN (" _   |  |", 7),
	EIGHT (" _ |_||_|", 8),
	NINE  (" _ |_| _|", 9);
	
	private final String signature;
	private final int value;
	OcrNumbers(String signature, int value){
		this.signature = signature;
		this.value = value;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public int getValue() {
		return value;
	}
}
