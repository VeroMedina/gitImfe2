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
import com.springboot.app.persistence.mappers.TestPruebaMapper;
import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestPruebaModel;
import com.springboot.app.utils.UtilStr;

@Service
public class TestPruebaServiceImpl implements TestPruebaService {

	@Autowired
	TestPruebaMapper iMapper;

	@Override
	public TestPruebaModel insertItemsService(ItemModel obj) throws Exception {
		
		TestPruebaModel y = iMapper.insertItemsMapper(obj);
				
		return y;
	}

	
	
	@Override
	public TestPruebaModel deleteItemsService(ItemModel obj) throws Exception {
		
		TestPruebaModel y = iMapper.deleteItemsMapper(obj);
		
		return y;
	}

	@Override
	public TestPruebaModel updateItemsService(ItemModel obj) throws Exception {
		
		TestPruebaModel y = iMapper.updateItemsMapper(obj);
		
		return y;
	}

	
	
	

}

