package com.springboot.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;
import com.springboot.app.services.EditService;



@Controller
public class EditController
{

  @Autowired
  EditService iService;


  @ResponseBody
  @RequestMapping(value = "/geteditable",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE) //vamos a usar Json
  public List<ItemModel> getEdiTable(@RequestBody TestModel obj) throws Exception
  {
	  System.out.println(obj.getTable());
	  
      List<ItemModel> x = iService.getEdiTable(obj);
      
    return x;
  }
  
  
}
