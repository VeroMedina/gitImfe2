package com.springboot.app.utils;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.springboot.app.persistence.models.ItemModel;

public class UtilStr
{

  /**
   * METODO PARA LIMPIAR UNA CADENA DE ESPACIOS EN BLANCOS, SALTOS DE CARROS Y
   * TABULADORES.
   *
   * @param str Cadena a limpiar.
   *
   * @return Cadena formateada.
   */
  public static String removeSpaces(String str)
  {
    return str.replaceAll("\\s+", " ").trim();
  }

  
  public static Matcher coinciden(String nombre, String nombre2) {
	return  pattern(nombre).matcher(nombre2);
		
	}
  
  /**
	 * METODO PARA GENERAR UN PATRON.
	 *
	 * @param obj
	 *  Cadena a insertar en el patron de busqueda.
	 *
	 * @return Patron generado.
	 */
	public static Pattern pattern(String str) {
		return Pattern.compile("(?i)" + str.replaceAll("\\s", ""));
		
	}

	
	
	
	/**
	 * METODO PARA REALIZAR UN REMPLAZO DE UNA CADENA POR UN TAG HTML.
	 *
	 * @param str
	 *            Cadena a insertar en el tag.
	 *
	 * @return tag generado en html.
	 */
	public static String patternReplaceHtml(String str) {
		return "<span class=\"searchSubrayado\">" + str + "</span>";
	}
	
	

	/**
	 * CONVERSION DEL TEXTO A SU FORMA CANONICAL DECOMPOSITION, REPRESENTANDO LOS
	 * CARACTERES UTF-8 COMPRENDIDOS ENTRE U+0300 HASTA U+036F.
	 * ------------------------------------
	 * <p>
	 * "[^\\p{ASCII}]"
	 * <p>
	 * "[\\p{InCombiningDiacriticalMarks}]"
	 *
	 * -------------------------------------
	 *
	 *
	 * @param str
	 *            Cadena a procesar.
	 *
	 * @return Cadena convertida a UTF-8.
	 */
	public String replaceChar(String str) {
		String normalize = str.replace("ñ", "\001");

		normalize = Normalizer.normalize(normalize, Normalizer.Form.NFD);
		normalize = normalize.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

		normalize = normalize.replace("\001", "ñ");

		return normalize;
	}


	

	
  
  
  

  
  
  
  
  
}