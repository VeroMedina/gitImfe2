package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;


public interface EditService
{

  public List<ItemModel> getEdiTable(TestModel obj) throws Exception;
 

}
