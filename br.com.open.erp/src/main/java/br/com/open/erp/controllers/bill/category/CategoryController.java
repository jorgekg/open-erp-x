package br.com.open.erp.controllers.bill.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.open.erp.controllers.ControllerImpl;
import br.com.open.erp.models.bill.Category;
import br.com.open.erp.services.Service;
import br.com.open.erp.services.bill.category.CategoryService;

@RestController
@RequestMapping("/bills/categories")
public class CategoryController extends ControllerImpl<Category>{

	@Autowired
	private CategoryService categoryService; 
	
	@Override
	public Service<Category> getService() {
		return categoryService;
	}

}
