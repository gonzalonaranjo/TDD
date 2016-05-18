import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;


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
	}
	
	@Test(expected = NoExisteClaveAsociada.class)
	public void addClaveDevuelveExcepcion(){
		tdd.put("Nombre", "Juan");
		tdd.get("Apellido");
	}
	@Test
	public void addClaveDevuelveValorSiNoExisteDevuelveValorPorDefecto(){
		tdd.put("Nombre", "Juan");
		assertEquals("Juan", tdd.getOrElse("Nombre", "0"));
		assertEquals("0", tdd.getOrElse("Apellido", "0"));
		
	}
}
