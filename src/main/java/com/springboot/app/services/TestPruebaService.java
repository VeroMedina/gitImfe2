/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestPruebaModel;

/**
 *
 * @author Lenovo
 */
public interface TestPruebaService
{

	public TestPruebaModel insertItemsService(ItemModel obj)throws Exception;
	public TestPruebaModel deleteItemsService(ItemModel obj) throws Exception;
	public TestPruebaModel updateItemsService(ItemModel obj) throws Exception;
       
 
}
