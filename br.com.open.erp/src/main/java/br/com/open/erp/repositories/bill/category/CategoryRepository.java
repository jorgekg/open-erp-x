package br.com.open.erp.repositories.bill.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.open.erp.models.bill.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryCustomRepository {
	
}
