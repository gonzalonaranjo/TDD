import static org.junit.Assert.*;

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
		tdd.put("Nombre", "Luis");
		assertEquals("Luis" , tdd.get("Nombre"));
	}
	@Test
	public void addClaveDosValoresModificaValor(){
		tdd.put("Nombre", "Luis");
		assertEquals("Luis", tdd.get("Nombre"));
		tdd.put("Nombre", "Pedro");
		assertEquals("Pedro", tdd.get("Nombre"));
		tdd.put("Apellido", "Prueba");
	}
}
