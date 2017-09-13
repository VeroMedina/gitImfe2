/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.app.services;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.springboot.app.utils.UtilStr;

import org.hibernate.internal.util.type.PrimitiveWrapperHelper.BooleanDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.persistence.mappers.ItemMapper;
import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.utils.UtilStr;


@Service
public class ItemServiceImpl implements ItemService
{
	
	@Autowired
	ItemMapper iMapper;
	
	
	

	/**
	 * METODO PARA BUSCAR TODOS LOS ITEMS DE LA BBDD
	 * return -> devuelve una lista de items o objetos
	 */
	@Override
	public List<ItemModel> searchAllService(ItemModel obj) throws Exception {
		List<ItemModel> y = iMapper.searchAllMapper(obj);

		return y;
	}
	
	
	
	
	/**
	 * METODO PARA BUSCAR UN ITEM POR NOMBRE O DESCRIPCION
	 * return -> devuelve una lista de items o objetos
	 */
	@Override
	  public List<ItemModel> searchItemsService(ItemModel obj) throws Exception
	  {
	    List<ItemModel> x = iMapper.searchItemsMapper(obj);

	    List<ItemModel> list = this.replaceSearch(obj, x);

	    return list;
	  }
	
	
	
	
	
//	/**
//	 * METODO PARA INSERTAR ITEMS EN LA BBDD
//	 * @param obj
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public List<ItemModel> insertItemsService(ItemModel obj) throws Exception {
//		
//		List<ItemModel> x = iMapper.insertItemsMapper(obj);
//
//	    return x;
//	}

	
	
	
	
	
	
	
	/**
	 ********************************************** 
	 * 
	 * 				METODOS PRIVADOS
	 * 
	 * 
	 **********************************************
	 */
	
		
	
	
  /**
   * METODO QUE RECIBE EL OBJETO BUSCADO Y LA LISTA DE LOS OBJETOS BUSCADOS DE
   * LA BBDD. SI EL OBJETO BUSCADO COINCIDE CON EL DE LA BBDD SERA REEMPLAZADO
   * SU ESTILO
   *
   * @param obj -> objeto,nombre o descripcion buscado.
   *
   * @param x -> lista de objetos de la bbdd buscados con todos sus propiedades
   *
   * @return -> devuelve la lista de los objetos buscados pero con su estilo
   * cambiado
   */
	private List<ItemModel> replaceSearch (ItemModel obj, List<ItemModel> x) 
	{
		//Creo la lista nueva
		List<ItemModel> listaNueva = new ArrayList <>();
		
    /**
     * Recorro el resultado de la bbdd de los items encontrados segun la
     * busqueda en item va los resutaldos de x.
     */
		for (ItemModel item : x) 
		{
      // Booleanos para comprobar coincidencias en la cadena.
      boolean name = false;
      boolean desc = false;
      
			
      /**
       * Se almacena el dato original de la bbdd, para su posterior uso en la 
       * sustitucion final.
       */
			String original = item.getNombre(); 
			String buscado = obj.getNombre();
			
			// Conversion a UTF-8(sin acento) la palabra que viene de la bbdd
			String originalUTF = UtilStr.replaceChar(original); 
      // Conversion a UTF-8(sin acento) la palabra que se busca
			buscado = UtilStr.replaceChar(buscado); 
			
 
			
      /**
       * Creacion de un objeto MATCHER para posteriormente:
       * 1- Evaluar empate (true | false). --> find()
       * 2- Inicio y final de una cadena. --> start()/end()
       */
		    Matcher objMatch = UtilStr.coinciden(buscado, originalUTF); 
 

			 // 1- Evaluar empate (true | false). --> find()
			if(objMatch.find())
			{
        System.out.println("bool.find() ---> ");
        
			// 2- Inicio y final de una cadena. --> start()/end()
				original = original.substring(objMatch.start(), objMatch.end());

			
        /**
         * Reemplazame todo lo que coincida con 'item.getNombre' y 'original' y
         * a su vez coincida con lo buscado.
         *
         * (item -> original) == buscado
         */
	       item.setNombre(
                 UtilStr.pattern(buscado).matcher(originalUTF)
                         .replaceAll(UtilStr.patternReplaceHtml(original))
         );
    
				name = true;
			}
			
      
      
       //Guardo en una variable el dato original de la bbdd
			String originalDescrip = item.getDescripcion(); 
			String buscadoDescrip = obj.getDescripcion();
      
            //Ejecuto metodo para convertir a UTF-8(sin acento) la palabra que viene de la bbdd
			String originalDescripUTF = UtilStr.replaceChar(originalDescrip);
      
       System.out.println("originalDescripUTF ---> " + originalDescripUTF);
      //Ejecuto metodo para convertir a UTF-8(sin acento) la palabra que se busca
			buscadoDescrip = UtilStr.replaceChar(buscadoDescrip);
      
      System.out.println("buscadoDescrip ---> " + buscadoDescrip);
      
             //Ejecutamos metodo para comprobar que lo buscado coincide con lo encontrado y si es que si devuelve un true
			Matcher boolDescrip = UtilStr.coinciden(buscadoDescrip, originalDescripUTF); 
			if (boolDescrip.find())
			{
        System.out.println("boolDescrip.find() ---> ");
        // Meto en la variable 'original' la parte de la palabra de la bbdd que coincide con lo buscado
				originalDescrip = originalDescrip.substring(boolDescrip.start(), boolDescrip.end());
				
				item.setDescripcion(UtilStr.pattern(buscadoDescrip).matcher(originalDescripUTF).replaceAll(UtilStr.patternReplaceHtml(originalDescrip)));

        desc = true;
			}
      
      if(name || desc)
      {
         System.out.println("LISTA ---> ");
            //Anade el nuevo item con el estilo modificado a la nueva lista
				listaNueva.add(item); 
      }
			
			
		}

		return listaNueva;
	}

	

	
	
	//METODOS BUSQUEDA POR CADENA O NUMERO
	
	// @Override
		// public List<ItemModel> searchCadenaService(ItemModel obj) throws Exception
		// {
		// List<ItemModel> y = iMapper.searchCadenaMapper(obj);
		//
		// List<ItemModel> lista = this.replace(obj,y); //Ejecutamos metodos y le
		// pasamos lo requerido por el metodo
		//
		// return lista;
		//
		//
		// }
		//
		//
		// @Override
		// public List<ItemModel> searchNumeroService(ItemModel obj) throws Exception
		// {
		// List<ItemModel> y = iMapper.searchNumeroMapper(obj);
		//
		// return y;
		// }
		//
	//////////////////////////////////////////////////////////////////

}
