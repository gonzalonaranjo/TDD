import java.util.Hashtable;

public class TDD {
	private Hashtable<String, String> tabla = new Hashtable<String, String>();
	
	/* crea una nueva entrada (un nuevo par) en la tabla . Si la clave existía
	 toma el nuevo valor.*/
	public void put(String clave, String valor){
		if(tabla.contains(clave)){
			tabla.replace(clave, valor);
		}else{
			tabla.put(clave, valor);
		}
	}
	/*Busca la clave en la tabla y devuelve el valor asociado; si la clave no existe 
	 * eleva una excepción.*/
	public String get(String clave){
		String devolver = "";

		if(tabla.containsKey(clave)){
			devolver = tabla.get(clave);
		}
		else{
			String mensaje = String.join(", ", tabla.toString());
			throw new NoExisteClaveAsociada(mensaje);
		}
		return devolver;
	}
	/*Busca la clave en la tabla y devuelve el valor asociado; si la clave no existe 
	 * devuelve valorPorDefecto.*/
	public String getOrElse(String clave, String valorPorDefecto){
		String devolver = valorPorDefecto;
		
		if(tabla.containsKey(clave)) devolver = tabla.get(clave);
		
		return devolver;
	}
	/*Devuelve TRUE si la clave existe y FALSE en caso contrario.*/
	public boolean containsKey(String clave){
		boolean v = false;
		
		if(tabla.containsKey(clave)) v = true;
		else v = false;
		
		return v;
	}
}
