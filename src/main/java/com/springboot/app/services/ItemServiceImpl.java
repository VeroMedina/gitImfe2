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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.persistence.mappers.ItemMapper;
import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.utils.UtilStr;

/**
 *
 * @author Lenovo
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemMapper iMapper;

	@Override
	public List<ItemModel> searchAllService(ItemModel obj) throws Exception {
		List<ItemModel> y = iMapper.searchAllMapper(obj);

		return y;
	}
	
	@Override
	  public List<ItemModel> searchItemsService(ItemModel obj) throws Exception
	  {
	    List<ItemModel> x = iMapper.searchItemsMapper(obj);

	    List<ItemModel> list = this.replaceSearch(obj, x);

	    return list;
	  }
	
	
	@Override
	public List<ItemModel> insertItemsService(ItemModel obj) throws Exception {
		
		List<ItemModel> x = iMapper.insertItemsMapper(obj);

	    return x;
	}

	
	/**
	 * Metodo que recibe el objeto buscado y la lista de los objetos buscados
	 * 
	 * @param obj
	 *            -> nombre buscado
	 * @param y
	 *            -> lista de objetos buscados con todos sus propiedades
	 * @return -> devuelve la lista de los objetos buscados pero con su estilo
	 *         cambiado
	 */
	private List<ItemModel> replaceSearch (ItemModel obj, List<ItemModel> x) 
	{
		//Creo la lista nueva
		List<ItemModel> listaNueva = new ArrayList <ItemModel>();
		
		for (ItemModel item : x) 
		{
			obj = UtilStr.replaceChar(obj.getNombre());
//			item = UtilStr.replaceChar(item);
			 
			
			String original =  item.getNombre();

			
			  Matcher bool = UtilStr.coinciden(obj, item.getNombre());
			
			if(bool.find())
			{
			
				original = original.substring(bool.start(), bool.end());
				
				 UtilStr.pattern(obj).matcher(item.getNombre()).replaceAll(UtilStr.patternReplaceHtml(original));
				
				listaNueva.add(item);
			}
			
//			item.setNombre(this.replaceStr(obj.getNombre(), item.getNombre()));
//
//			item.setDescripcion(this.replaceStr(obj.getDescripcion(), item.getDescripcion()));
		}

		return listaNueva;
	}

	/**
	 * METODO PARA REEMPLAZAR LA CADENA BUSCADA EN UN STRING.
	 *
	 * @param obj
	 *            Cadena buscada.
	 * @param item
	 *            Cadena a procesar.
	 *
	 * @return Cadena reemplazada.
	 */
//	private String replaceStr(String obj, String item) {
//		
//
//		
//
//		Matcher x = this.pattern(obj).matcher(item);
//
//		if (x.find() && (obj.length() > 0)) {
//			
//		}
//
//		return replace;
//	}

	
	
	
	
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
	

}
