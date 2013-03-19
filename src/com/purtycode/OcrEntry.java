package com.purtycode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OcrEntry {

	private static final int ACCT_NUM_LENGTH = 9;
	private static final int OCR_ENTRY_WIDTH = 27;
	private static final int OCR_NUMBER_WIDTH = 3; 
	
	private List<String> entryLines;
	private HashMap<String, Integer> numberConverter;
	
	private String topOfEntry;
	private String middleOfEntry;
	private String bottomOfEntry;
	
	public OcrEntry() {
		this.numberConverter = new HashMap<String, Integer>();
		entryLines = new ArrayList<String>();
		
		for (OcrNumbers number:OcrNumbers.values()) {
			this.numberConverter.put(number.getSignature(), number.getValue());
		}
	}
	
	public void addLine(String newLine) {
		this.entryLines.add(newLine);
	}

	public int[] convertOcrLinesToIntArray() {
		topOfEntry = this.entryLines.get(0);
		middleOfEntry = this.entryLines.get(1);
		bottomOfEntry = this.entryLines.get(2);
		
		int[] convertedNumbers = new int[9];
		int convNumPosition = 0;
		
		for(int position=0;position < OCR_ENTRY_WIDTH;position += OCR_NUMBER_WIDTH){
			
			String ocrNumberSignature = this.buildOcrNumberSignature(position);
			
			if(numberConverter.containsKey(ocrNumberSignature)) {
				convertedNumbers[convNumPosition] = numberConverter.get(ocrNumberSignature);
			}
			convNumPosition++;
		}
		return convertedNumbers;	
	}
	
	private String buildOcrNumberSignature(int position) {
		
		String topOfNumber = topOfEntry.substring(position, position + OCR_NUMBER_WIDTH);
		String middleOfNumer = middleOfEntry.substring(position, position + OCR_NUMBER_WIDTH);
		String bottomOfNumber = bottomOfEntry.substring(position, position + OCR_NUMBER_WIDTH);
		
		StringBuilder ocrEntryNumber = new StringBuilder();
		ocrEntryNumber.append(topOfNumber).append(middleOfNumer).append(bottomOfNumber);
		
		return ocrEntryNumber.toString();
	}
	
	public boolean validateOcrAccountNumber(int[] accountNumber) {
		int accountNumCheckSum = 0;
		
		for(int acctNumPosition=0;acctNumPosition < ACCT_NUM_LENGTH; acctNumPosition++) {
			int currentDigit = accountNumber[acctNumPosition];
			accountNumCheckSum += (currentDigit * (ACCT_NUM_LENGTH - acctNumPosition));
		}
		
		int remainder = accountNumCheckSum % 11;
		
		if (remainder == 0) {
			return true;
		} else {
			return false;
		}
	}
}
