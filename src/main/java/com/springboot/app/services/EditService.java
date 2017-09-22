package com.springboot.app.services;

import java.util.List;
import java.util.Map;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;


public interface EditService
{

  public List<Map<String, Object>> getEdiTable(TestModel obj) throws Exception;
 

}
