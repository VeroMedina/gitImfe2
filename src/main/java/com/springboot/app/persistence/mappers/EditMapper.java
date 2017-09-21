package com.springboot.app.persistence.mappers;

import java.util.List;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;


public interface EditMapper
{
  public List<ItemModel> getEdiTable(TestModel obj) throws Exception;
  
  
}