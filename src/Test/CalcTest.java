package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Calc;
import Model.negativesNotAllowedException;

public class CalcTest {

	Calc calc;

	@Before
	public void setup() {
		calc = new Calc();
	}

	@Test(expected = negativesNotAllowedException.class)
	public void negativeNumberWillThrowAnException() throws Exception {
		int result = calc.add("-3;4;5");
	}

	@Test
	// Empty string retun 0
	public void addReturn0WhenStringIsEmpty() throws Exception {
		int result = Calc.add("");
		assertEquals(result, 0);
	}

	@Test
	public void addOneNumber() throws Exception {
		int result = calc.add("3");
		assertEquals(result, 3);
	}

	@Test
	public void addTwoNumber() throws Exception {
		int result = calc.add("3;4");
		assertEquals(result, 7);
	}

	@Test
	public void addThreeNumber() throws Exception {
		int result = calc.add("3;4;5");
		assertEquals(result, 12);
	}

	@Test
	public void addUnknownAmountOfNumbers() throws Exception {

		int result = calc.add("3;4;5;1;3;4");
		assertEquals(result, 20);
	}

	@Test
	public void addToHandleNewLinesBetweenNumbers() throws Exception {
		int result = calc.add("3;4;5\n1;3;4");
		assertEquals(result, 20);

	}

	@Test
	public void supportDifferentDelimiter() throws Exception {

		int result = calc.add("\\[|]\n3|4|5|1|3|4");
		assertEquals(result, 20);

	}
	
	@Test
	public void supportStringDelimiter() throws Exception {

		int result = calc.add("\\[***]\n3***4***5***1***3***4");
		assertEquals(result, 20);

	}
	
	@Test
	public void supportMultipleStringDelimiter() throws Exception {

		int result = calc.add("\\[***][!!][;;]\n3***4;;5***1!!3***4");
		assertEquals(result, 20);

	}

	@Test
	public void UseSemicolonAsDefualtDelimiterWhenDelimeterIsUndefined()
			throws Exception {
		int result = calc.add("3;4;5;1;3;4");
		assertEquals(result, 20);
	}

	@Test
	public void NumbersBiggerThan1000ShouldBeIgnored() throws negativesNotAllowedException {
		int result = calc.add("3;4;5;1;3;1001");
		assertEquals(result, 16);
	}

}
