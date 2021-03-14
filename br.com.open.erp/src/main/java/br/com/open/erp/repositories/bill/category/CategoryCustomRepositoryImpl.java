package br.com.open.erp.repositories.bill.category;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.EntityPathBase;

import br.com.open.erp.models.bill.Category;
import br.com.open.erp.models.bill.QCategory;
import br.com.open.erp.repositories.RepositoryImpl;

@Repository
@Primary
public class CategoryCustomRepositoryImpl extends RepositoryImpl<Category> implements CategoryCustomRepository {

	@Override
	public EntityPathBase<Category> getEntity() {
		return QCategory.category;
	}

}
