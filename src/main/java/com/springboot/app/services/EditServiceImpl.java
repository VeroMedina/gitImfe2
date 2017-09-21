package com.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.persistence.mappers.EditMapper;
import com.springboot.app.persistence.mappers.TestMapper;
import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;


@Service
public class EditServiceImpl implements EditService
{

  @Autowired
  EditMapper iMapper;


  @Override
  public List<ItemModel> getEdiTable(TestModel obj) throws Exception
  {
    List<ItemModel> x = iMapper.getEdiTable(obj);
    
    return x;
  }
  
  

}
