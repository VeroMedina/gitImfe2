package com.springboot.app.persistence.mappers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestPruebaModel;
import com.springboot.app.utils.UtilStr;


@Repository
public class TestPruebaMapperImpl implements testPruebaMapper
{
	@Autowired
	JdbcTemplate JdbcTemplate;
	
	
	@Override
	public TestPruebaModel insertItemsMapper(ItemModel obj) throws Exception 
	{
		 String sql = UtilStr.removeSpaces(
		            " INSERT INTO items " +
		            " (nombre, " +
		            "  descripcion, " +
		            "  url) " +
		            " VALUES " +
		            " ('" + obj.getNombre() + "'" +
		            " ,'" + obj.getDescripcion() + "'" +
		            " ,'" + obj.getUrl() + "')");

		   TestPruebaModel rdo = new TestPruebaModel();
		   rdo.setRdosql(JdbcTemplate.update(sql));
		   
		   return rdo;
	}
	
	@Override
	  public TestPruebaModel updateItemsMapper(ItemModel obj) throws Exception
	  {
	    String sql = UtilStr.removeSpaces(
	            " UPDATE items     " +
	            " SET nombre=     '" + obj.getNombre() + "'" +
	            "    ,descripcion='" + obj.getDescripcion() + "'" +
	            "    ,url=        '" + obj.getUrl() + "'" +
	            " WHERE id=        " + obj.getId());

	    TestPruebaModel rdo = new TestPruebaModel();
	    rdo.setRdosql(JdbcTemplate.update(sql));
	    
	    return rdo;
	  }


	  @Override
	  public TestPruebaModel deleteItemsMapper(ItemModel obj) throws Exception
	  {
	    String sql = UtilStr.removeSpaces(
	            " DELETE FROM items " +
	            " WHERE id=         " + obj.getId());
	    
	    TestPruebaModel rdo = new TestPruebaModel();
	    rdo.setRdosql(JdbcTemplate.update(sql));
	    
	    return rdo;
	  }

	
	
}
