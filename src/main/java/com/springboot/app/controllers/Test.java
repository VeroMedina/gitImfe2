package com.springboot.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.persistence.models.TestModel;
import com.springboot.app.services.TestService;


@Controller
public class Test
{

  @Autowired
  TestService iService;


  @ResponseBody
  @RequestMapping(value = "/test",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE) //vamos a usar Json
  public List<TestModel> test(@RequestBody TestModel obj) throws Exception
  {
      System.out.println(obj.getPropiedad());
      System.out.println(obj.getTable());
      
      List<TestModel> x = iService.testService(obj);

    return x;
  }
  
  
}
