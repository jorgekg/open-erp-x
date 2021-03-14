package br.com.open.erp.services;

import br.com.open.erp.utils.FilterImpl;
import br.com.open.erp.utils.Page;

public interface Service<T> {

	T create(T entity);
	T update(Long id, T entity);
	T get(Long id);
	Page<T> list(FilterImpl filter);
	T retrieve(Long id);
	void delete(Long id);
	
}
