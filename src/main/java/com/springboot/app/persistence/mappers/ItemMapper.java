/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.app.persistence.mappers;

import java.util.List;

import com.springboot.app.persistence.models.ItemModel;

/**
 *
 * @author Lenovo
 */
public interface ItemMapper 
{

    public List<ItemModel> searchAllMapper (ItemModel obj) throws Exception;
    public List<ItemModel> searchItemsMapper (ItemModel obj) throws Exception;

	
}
