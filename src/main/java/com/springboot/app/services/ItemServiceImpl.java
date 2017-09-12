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
	 * METODO QUE RECIBE EL OBJETO BUSCADO Y LA LISTA DE LOS OBJETOS BUSCADOS DE LA BBDD. SI EL OBJETO BUSCADO COINCIDE CON EL DE LA BBDD
	 * SERA REEMPLAZADO SU ESTILO
	 * 
	 * @param obj -> objeto,nombre o descripcion buscado.
	 *            
	 * @param x -> lista de objetos de la bbdd buscados con todos sus propiedades
	 *            
	 * @return -> devuelve la lista de los objetos buscados pero con su estilo
	 *         cambiado
	 */
	private List<ItemModel> replaceSearch (ItemModel obj, List<ItemModel> x) 
	{
		//Creo la lista nueva
		List<ItemModel> listaNueva = new ArrayList <ItemModel>();
		
		//Recorro el resultado de la bbdd de los items encontrados segun la busqueda
		for (ItemModel item : x) //En item va los resutaldos de x
		{
			
			String original = item.getNombre(); //Guardo en una variable el dato original de la bbdd
			String buscado = obj.getNombre();
			
			String originalDescrip = item.getDescripcion(); //Guardo en una variable el dato original de la bbdd
			String buscadoDescrip = obj.getDescripcion();
			
			
			original = UtilStr.replaceChar(original); //Ejecuto metodo para convertir a UTF-8(sin acento) la palabra que viene de la bbdd
			buscado = UtilStr.replaceChar(buscado); //Ejecuto metodo para convertir a UTF-8(sin acento) la palabra que se busca
			
			originalDescrip = UtilStr.replaceChar(originalDescrip); //Ejecuto metodo para convertir a UTF-8(sin acento) la palabra que viene de la bbdd
			buscadoDescrip = UtilStr.replaceChar(buscadoDescrip); //Ejecuto metodo para convertir a UTF-8(sin acento) la palabra que se busca
			
			 		
		    Matcher bool = UtilStr.coinciden(buscado, original); //Ejecutamos metodo para comprobar que lo buscado coincide con lo encontrado y si es que si devuelve un true
			Matcher boolDescrip = UtilStr.coinciden(buscadoDescrip, originalDescrip); //Ejecutamos metodo para comprobar que lo buscado coincide con lo encontrado y si es que si devuelve un true

			  
			if(bool.find())//Si coincide la busqueda
			{
			
				original = original.substring(bool.start(), bool.end());// Meto en la variable 'original' la parte de la palabra de la bbdd que coincide con lo buscado

			
				//Reemplazame todo lo que coincida con 'item.getNombre' y 'original' y a su vez coincida con lo buscado
				item.setNombre(UtilStr.pattern(buscado).matcher(item.getNombre()).replaceAll(UtilStr.patternReplaceHtml(original)));

				listaNueva.add(item); //Añade el nuevo item con el estilo modificado a la nueva lista
				
			}
			
			if (boolDescrip.find())
			{
				originalDescrip = originalDescrip.substring(boolDescrip.start(), boolDescrip.end());// Meto en la variable 'original' la parte de la palabra de la bbdd que coincide con lo buscado
				
				item.setDescripcion(UtilStr.pattern(buscadoDescrip).matcher(item.getDescripcion()).replaceAll(UtilStr.patternReplaceHtml(originalDescrip)));
				
				listaNueva.add(item); //Añade el nuevo item con el estilo modificado a la nueva lista
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
