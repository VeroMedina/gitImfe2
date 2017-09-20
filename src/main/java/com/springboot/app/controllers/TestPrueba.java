package com.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.services.ItemService;
import com.springboot.app.utils.UtilStr;

@Controller
public class TestPrueba {
	
	
	@Autowired
	ItemService iService;


	@ResponseBody
	@RequestMapping(value = "/insertOneItems", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int insertItems(@RequestBody ItemModel obj) throws Exception {

		
		ItemModel item = new ItemModel();
		
		List <ItemModel> array = new ArrayList <>();
		
	
		item.setNombre("Tarta red Velvet");
		item.setDescripcion("tarta roja con crema de queso");
		item.setUrl("https://static.guiainfantil.com/pictures/recetas/4826-4-tarta-red-velvet-receta-paso-a-paso-para-sorprender.jpg");
		
		array.add(item);
		
		item.setNombre("Tarta galletas");
		item.setDescripcion("la mejor tarta");
		item.setUrl("https://www.recetassinlactosa.com/wp-content/uploads/2016/06/Tarta-de-galletas-y-moka.jpg");
		
		array.add(item);

		int y = iService.insertOneItemsService(array);

		if (y > 0) {

			item.setRdosql(y);
		}

		System.out.println("Se ha añadido" + item.getRdosql() + "registros");

		return y;

	}

	

}
