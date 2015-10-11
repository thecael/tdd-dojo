import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinTapeDifferenceTest
{
	private MinTapeDifference minTapeDifference;

	@Before
	public void initTest() {
		minTapeDifference = new MinTapeDifference();
	}

	@Test
	public void tapeWithTwoValues() throws Exception
	{
		int[] tape = new int[] { 2, 1 };
		int result = minTapeDifference.calcMinTapeDifference(tape);
		assertEquals(1, result);
	}

	@Test
	public void tapeWithNegativeDifference() throws Exception
	{
		int[] tape = new int[] { 1, 2 };
		int result = minTapeDifference.calcMinTapeDifference(tape);
		assertEquals(1, result);
	}

	@Test
	public void tapeWithANegativeValue() throws Exception
	{
		int[] tape = new int[] { 3, -1 };
		int result = minTapeDifference.calcMinTapeDifference(tape);
		assertEquals(4, result);
	}

	@Test
	public void tapeWithThreeItems() throws Exception
	{
		int[] tape = new int[] { 2, 1, 3 };
		int result = minTapeDifference.calcMinTapeDifference(tape);
		assertEquals(0, result);
	}

	@Test
	public void testTapeWithFourItems() throws Exception
	{
		int[] tape = new int[] { 2, 1, 3, 4 };
		int result = minTapeDifference.calcMinTapeDifference(tape);
		assertEquals(2, result);
	}
}
