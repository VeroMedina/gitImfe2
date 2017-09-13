
package com.springboot.app.persistence.mappers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.utils.UtilStr;

/**
 *
 * @author Lenovo	
*/
@Repository
public class ItemMapperImpl implements ItemMapper
{

	@Autowired
	  JdbcTemplate JdbcTemplate;


	  @Override
	  public List<ItemModel> searchAllMapper(ItemModel obj) throws Exception
	  {
	    String sql = " SELECT * " +
	                 " FROM items " +
	                 " ORDER BY id DESC ";

	    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemModel.class));
	  }


	  @Override
	  public List<ItemModel> searchItemsMapper(ItemModel obj) throws Exception
	  {
	    String sql = UtilStr.removeSpaces(" SELECT * " +
	                 " FROM items " +
	                 " WHERE (nombre LIKE '%" + obj.getPropiedad() + "%') " +
	                 " OR (descripcion LIKE '%" + obj.getPropiedad() + "%') " +
	                 " ORDER BY id DESC ");

	    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemModel.class));
	  }


	@Override
	public int insertItemsMapper(ItemModel obj) throws Exception 
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

		    return JdbcTemplate.update(sql);
		  }
	
	@Override
	  public int updateItemsMapper(ItemModel obj) throws Exception
	  {
	    String sql = UtilStr.removeSpaces(
	            " UPDATE items     " +
	            " SET nombre=     '" + obj.getNombre() + "'" +
	            "    ,descripcion='" + obj.getDescripcion() + "'" +
	            "    ,url=        '" + obj.getUrl() + "'" +
	            " WHERE id=        " + obj.getId());

	    return JdbcTemplate.update(sql);
	  }


	  @Override
	  public int deleteItemsMapper(ItemModel obj) throws Exception
	  {
	    String sql = UtilStr.removeSpaces(
	            " DELETE FROM items " +
	            " WHERE id=         " + obj.getId());

	    return JdbcTemplate.update(sql);
	  }

}