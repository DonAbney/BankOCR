package com.purtycode.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.purtycode.OcrEntry;
import com.purtycode.OcrInputHandler;

public class OcrInputHandlerTester {

	OcrInputHandler ocrInputHandler;
	FileInputStream validOcrInputFile;
	FileInputStream emptyOcrInputFile;

	@Before
	public void setUp() throws Exception {
		validOcrInputFile = new FileInputStream("./resources/validTestInput.txt");
		ocrInputHandler = new OcrInputHandler(validOcrInputFile);
	}

	@Test
	public void parseFileIntoEntriesReturnsValidListOfEntries() throws IOException {
		List<OcrEntry> entryList = ocrInputHandler.convertFileToEntryList(validOcrInputFile);
		assertTrue(entryList.size() == 3);
	}
		
	@Test
	public void parseEntryReturnsValidListOfNumbers1Thru9() throws IOException {
		int[] expectedIntArray = {1,2,3,4,5,6,7,8,9};
		OcrEntry entry = createValidEntry1Thru9();
		assertArrayEquals(expectedIntArray, ocrInputHandler.parseEntry(entry));
	}
	
	@Test
	public void parseEntryReturnsValidListOfNumbers0Thru8() throws IOException {
		int[] expectedIntArray = {0,1,2,3,4,5,6,7,8};
		OcrEntry entry = createValidEntry0Thru8();
		assertArrayEquals(expectedIntArray, ocrInputHandler.parseEntry(entry));
	}

	private OcrEntry createValidEntry1Thru9() {
		OcrEntry ocrEntry = new OcrEntry();
		ocrEntry.addLine("    _  _     _  _  _  _  _ ");
		ocrEntry.addLine("  | _| _||_||_ |_   ||_||_|");
		ocrEntry.addLine("  ||_  _|  | _||_|  ||_| _|");
		return ocrEntry;
	}
	
	private OcrEntry createValidEntry0Thru8() {
		OcrEntry ocrEntry = new OcrEntry();
		ocrEntry.addLine(" _     _  _     _  _  _  _ ");
		ocrEntry.addLine("| |  | _| _||_||_ |_   ||_|");
		ocrEntry.addLine("|_|  ||_  _|  | _||_|  ||_|");
		return ocrEntry;
	}
}
