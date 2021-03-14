package br.com.open.erp.services.bill.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.open.erp.models.bill.Category;
import br.com.open.erp.repositories.bill.category.CategoryRepository;
import br.com.open.erp.services.ServiceImpl;

@Service
public class CategoryService extends ServiceImpl<Category> {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public JpaRepository<Category, Long> getRepository() {
		return categoryRepository;
	}

	@Override
	public void validator(Category entity) {
	}

}
