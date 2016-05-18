import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class TDDTest {
	
	private TDD tdd;
	
	@Before
	public void setUp(){
		tdd = new TDD();
	}
	@Test
	public void addClaveReturnsValue(){
		tdd.put("Nombre", "Lus");
		assertEquals("Luis" , tdd.get("Nombre"));
	}
}
