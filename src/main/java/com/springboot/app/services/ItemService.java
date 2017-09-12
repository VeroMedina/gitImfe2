/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.models.ItemModel;

/**
 *
 * @author Lenovo
 */
public interface ItemService 
{
//     public List<ItemModel> searchCadenaService(ItemModel obj) throws Exception;
       public List<ItemModel> searchAllService(ItemModel obj) throws Exception;
       public List<ItemModel> searchItemsService(ItemModel obj) throws Exception;
       public List<ItemModel> insertItemsService(ItemModel obj) throws Exception;
 //     public List<ItemModel> searchNumeroService(ItemModel obj) throws Exception;
}
