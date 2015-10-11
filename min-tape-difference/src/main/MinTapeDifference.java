public class MinTapeDifference
{
	public static void main(String[] args)
	{
		MinTapeDifference minTapeDifference = new MinTapeDifference();
		int[] values = new int[] { 5, 2, 8, 8, 5 };
		int minDiff = minTapeDifference.calcMinTapeDifference(values);
		System.out.println("Min. tape difference is " + minDiff);
	}

	public int calcMinTapeDifference(int[] tape)
	{
		int minDiff = 1000;
		for (int i = 0; i < tape.length - 1; i++)
		{
			int leftPart = sumTapePart(tape, 0, i + 1);
			int rightPart = sumTapePart(tape, i + 1, tape.length);
			int diff = Math.abs(leftPart - rightPart);
			if (diff < minDiff)
			{
				minDiff = diff;
			}
		}

		return minDiff;
	}

	private int sumTapePart(int[] tape, int from, int to)
	{
		int result = 0;
		for (int i = from; i < to; i++)
		{
			result += tape[i];
		}
		return result;
	}
}
