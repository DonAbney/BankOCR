package com.purtycode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OcrInputHandler {
	
	private BufferedReader OcrFile;
	private HashMap<String, Integer> numberConverter;

	public OcrInputHandler(FileInputStream inputFile) {
		this.OcrFile = new BufferedReader(new InputStreamReader(inputFile));
		
		this.numberConverter = new HashMap<String, Integer>();
		for (OcrNumbers number:OcrNumbers.values()) {
			this.numberConverter.put(number.getSignature(), number.getValue());
		}
	}

	public List<OcrEntry> convertFileToEntryList(FileInputStream inputFile) throws IOException {
		List<OcrEntry> entryList = new ArrayList<OcrEntry>();
		String currentLine;
		OcrEntry ocrEntry = new OcrEntry();

		while ((currentLine = OcrFile.readLine()) != null) {
			if (currentLine.trim().isEmpty()) {
				entryList.add(ocrEntry);
				ocrEntry = new OcrEntry();
			} else {
				ocrEntry.addLine(currentLine);
			}
		}
		return entryList;
	}

	public int[] parseEntry(OcrEntry ocrEntry) {
		return ocrEntry.convertOcrLinesToIntArray();
	}
}