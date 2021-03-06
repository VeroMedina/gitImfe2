package com.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.services.ItemService;
import com.springboot.app.utils.UtilStr;

@Controller
public class Item 
{
	
	@Autowired
	ItemService iService;

	@ResponseBody
	@RequestMapping(value = "/searchAll", 
	method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) // vamos																											// Json
	public List<ItemModel> searchAll(@RequestBody ItemModel obj) throws Exception {

		List<ItemModel> y = iService.searchAllService(obj);
		
		return y;

	}

	@ResponseBody
	@RequestMapping(value = "/searchItems", 
	method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 																											
	public List<ItemModel> searchItems(@RequestBody ItemModel obj) throws Exception {

		List<ItemModel> y = null;

		if (UtilStr.removeSpaces(obj.getPropiedad()).length() > 0) {
			y = iService.searchItemsService(obj);

			if (y.size() > 0) {
				y = iService.subrayarItemsService(obj, y);
			}
		} else {
			y = iService.searchAllService(obj);
		}

		return y;

	}



}
