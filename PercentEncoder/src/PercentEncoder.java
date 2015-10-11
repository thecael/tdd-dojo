public class PercentEncoder
{

    public static void main(String[] args) {
        PercentEncoder percentEncoder = new PercentEncoder();
		String encoded = percentEncoder.encode("http://www.google.de");
		System.out.println("Encoded String: " + encoded);
	}

	public String encode(String input)
	{
		input = input.replaceAll("%", "%25");
		input = input.replaceAll(" ", "%20");
		input = input.replaceAll("\\\\", "%5C");
		input = input.replaceAll("\\.", "%2E");
		input = input.replaceAll("\\[", "%5B");
		input = input.replaceAll("\\]", "%5D");
		return input;
	}
}
