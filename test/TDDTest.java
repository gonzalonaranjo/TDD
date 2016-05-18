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
	@Test
	public void devuelveTrueSiExisteClave(){
		tdd.put("Nombre", "Juan");
		assertEquals(true, tdd.containsKey("Nombre"));
		
	}
	@Test
	public void devuelveFalseSiNoExisteClave(){
		tdd.put("Nombre", "Juan");
		assertEquals(false, tdd.containsKey("Apellidos"));	
	}
	@Test
	public void devuelveTrueSiBorraClave(){
		tdd.put("Nombre", "Emilio");
		assertEquals(true, tdd.remove("Nombre"));	
	}
	@Test
	public void devuelveFalseSiNoPuedeBorrarClave(){
		tdd.put("Apellidos", "Fernández");
		assertEquals(false, tdd.remove("Nombre"));
	}
	@Test
	public void devuelveCeroSiLaTablaEstaVacia(){
		assertEquals(0, tdd.size());
		
	}
	@Test
	public void devuelveUnoSiHayUnElemento(){
		tdd.put("Apellidos", "Rondón");
		assertEquals(1, tdd.size());
		
	}
	@Test
	public void devuelveTresSiHayTresElementos(){
		tdd.put("Nombre", "Salomón");
		tdd.put("Apellido", "Rondón");
		tdd.put("Edad", "27");
		assertEquals(3, tdd.size());
	}
}
