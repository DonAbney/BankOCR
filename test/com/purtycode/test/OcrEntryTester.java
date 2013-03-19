package com.purtycode.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.purtycode.OcrEntry;

public class OcrEntryTester {
	
	OcrEntry ocrEntry;
	
	@Before
	public void setup() throws Exception {
		ocrEntry = new OcrEntry();
	}

	@Test
	public void ocrEntryConvertsValidEntryToIntArray() {
		int[] expectedIntArray = {1,2,3,4,5,6,7,8,9};
		List<String> entryLines = createValidEntryLines();
		ocrEntry.addLine(entryLines.get(0));
		ocrEntry.addLine(entryLines.get(1));
		ocrEntry.addLine(entryLines.get(2));
		
		assertArrayEquals(expectedIntArray, ocrEntry.convertOcrLinesToIntArray());
	}
	
	@Test
	public void validAccountNumberPassesChecksum() {
		int[] accountNumber = {3,4,5,8,8,2,8,6,5};
		assertTrue(ocrEntry.validateOcrAccountNumber(accountNumber));
	}
	
	@Test
	public void invalidAccountNumberFailsChecksum() {
		int[] accountNumber = {6,6,4,3,7,1,4,9,5};
		assertFalse(ocrEntry.validateOcrAccountNumber(accountNumber));
	}

	private List<String> createValidEntryLines() {
		List<String> entryLines = new ArrayList<String>();
		entryLines.add("    _  _     _  _  _  _  _ ");
		entryLines.add("  | _| _||_||_ |_   ||_||_|");
		entryLines.add("  ||_  _|  | _||_|  ||_| _|");
		return entryLines;
	}
}
