package com.springboot.app.persistence.mappers;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EditMapperImpl implements EditMapper
{

  @Autowired
  JdbcTemplate JdbcTemplate;


  @Override
  public List<Map<String, Object>> getEdiTable(TestModel obj) throws Exception
  {

	    String sql = " SELECT * " +
                " FROM " + obj.getTable() ;

	    return JdbcTemplate.queryForList(sql);

  }
}