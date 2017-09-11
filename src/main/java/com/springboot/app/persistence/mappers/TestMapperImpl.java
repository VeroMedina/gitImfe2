package com.springboot.app.persistence.mappers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.springboot.app.persistence.models.TestModel;


@Repository
public class TestMapperImpl implements TestMapper
{

	@Override
	public List<TestModel> testMapper(TestModel obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//  @Autowired
//  BBDD db;
//
//
//  @Override
//  public List<TestModel> testMapper(TestModel obj) throws Exception
//  {
//
//    List<TestModel> x = new ArrayList<>();
//
//    /**
//     * CONECTANDO A LA BBDD.
//     */
//    db.conecta();
//
//    /**
//     * RECORRIENDO LAS TABLAS.
//     */
//    for (int i = 0; i < db.tablas().size(); i++)
//    {
//      TestModel table = new TestModel();
//
//      table.setTable(db.tablas().get(i).toUpperCase());
//
//      System.out.println();
//      System.out.printf("___%-12s", table.getTable());
//      System.out.println();
//
//      /**
//       * RECORRIENDO LAS COLUMNAS DE LA TABLA SELECCIONADA.
//       */
//      for (int j = 0; j < db.columnas(db.tablas().get(i)).size(); j++)
//      {
//        System.out.printf("| %-16s", db.columnas(table.getTable()).get(j));
//        /**
//         * CONSULTANDO LOS VALORES DE LA COLUMNA SELECCIONADA.
//         */
//        String sql = "SELECT " + db.columnas(table.getTable()).get(j) + " FROM " + table.
//                     getTable();
//
//        ResultSet rs = db.consulta(sql);
//        while (rs.next())
//        {
//          System.out.print(" ");
//          System.out.printf("| %-20s", rs.getString(db.columnas(db.tablas().
//                            get(i)).get(j)));
//        }
//
//        System.out.println();
//      }
//      System.out.println();
//
//      x.add(table);
//    }
//    /**
//     * DESCONECTANDO A LA BBDD.
//     */
//    db.desconecta();
//
//    return x;
//  }
//  
  
  

}
