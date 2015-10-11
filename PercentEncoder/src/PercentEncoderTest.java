import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PercentEncoderTest
{
	private PercentEncoder percentEncoder;

	@Before
	public void initTest() {
		percentEncoder = new PercentEncoder();
	}

	@Test
	public void encodeSpace() throws Exception
	{
		assertEquals("%20", percentEncoder.encode(" "));
	}

	@Test
	public void encodeBackslash() throws Exception
	{
		assertEquals("%5C", percentEncoder.encode("\\"));
	}

	@Test
	public void encodePercent() throws Exception
	{
		assertEquals("%25", percentEncoder.encode("%"));
	}

	@Test
	public void encodeDot() throws Exception
	{
		assertEquals("%2E", percentEncoder.encode("."));
	}

	@Test
	public void encodeMultipleReservedChars() throws Exception
	{
		assertEquals("%2E%25", percentEncoder.encode(".%"));
	}

	@Test
	public void encodeOpeningSquareBracket() {
		assertEquals("%5B", percentEncoder.encode("["));
	}

	@Test
	public void encodeClosingSquareBracket() {
		assertEquals("%5D", percentEncoder.encode("]"));
	}

	@Test
	public void encodeAt() {
		assertEquals("%40", percentEncoder.encode("@"));
	}

	@Test
	public void encodeSlash() {
		assertEquals("%2F", percentEncoder.encode("/"));
	}

	@Test
	public void encodeColon() {
		assertEquals("%3A", percentEncoder.encode(":"));
	}

	@Test
	public void encodeSemicolon() {
		assertEquals("%3B", percentEncoder.encode(";"));
	}

	@Test
	public void encodeEqualSign() {
		assertEquals("%3D", percentEncoder.encode("="));
	}

	@Test
	public void encodeReservedAndUnreservedChars() throws Exception
	{
		assertEquals("Hallo%5CWie%20geht%20es%25", percentEncoder.encode("Hallo\\Wie geht es%"));
	}

	@Test
	public void encodeNothing() throws Exception
	{
		assertEquals("", percentEncoder.encode(""));
	}
}
