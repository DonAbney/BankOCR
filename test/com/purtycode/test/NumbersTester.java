package com.purtycode.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.purtycode.OcrNumbers;

public class NumbersTester {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validStringSignaturesReturnCorrectNumber(){
		assertEquals(" _ | ||_|", OcrNumbers.ZERO.getSignature());
		assertEquals("     |  |", OcrNumbers.ONE.getSignature());
		assertEquals(" _  _||_ ", OcrNumbers.TWO.getSignature());
		assertEquals(" _  _| _|", OcrNumbers.THREE.getSignature());
		assertEquals("   |_|  |", OcrNumbers.FOUR.getSignature());
		assertEquals(" _ |_  _|", OcrNumbers.FIVE.getSignature());
		assertEquals(" _ |_ |_|", OcrNumbers.SIX.getSignature());
		assertEquals(" _   |  |", OcrNumbers.SEVEN.getSignature());
		assertEquals(" _ |_||_|", OcrNumbers.EIGHT.getSignature());
		assertEquals(" _ |_| _|", OcrNumbers.NINE.getSignature());
	}
	
	@Test
	public void validIntSignaturesReturnCorrectNumber(){
		assertEquals(0, OcrNumbers.ZERO.getValue());
		assertEquals(1, OcrNumbers.ONE.getValue());
		assertEquals(2, OcrNumbers.TWO.getValue());
		assertEquals(3, OcrNumbers.THREE.getValue());
		assertEquals(4, OcrNumbers.FOUR.getValue());
		assertEquals(5, OcrNumbers.FIVE.getValue());
		assertEquals(6, OcrNumbers.SIX.getValue());
		assertEquals(7, OcrNumbers.SEVEN.getValue());
		assertEquals(8, OcrNumbers.EIGHT.getValue());
		assertEquals(9, OcrNumbers.NINE.getValue());
	}

}
