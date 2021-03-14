package br.com.open.erp.repositories;

import org.springframework.transaction.annotation.Transactional;

import br.com.open.erp.utils.FilterImpl;
import br.com.open.erp.utils.Page;

@org.springframework.stereotype.Repository
public interface Repository<T> {
	
	@Transactional(readOnly = true)
	public T retrieve(Long id);
	
	public Page<T> list(FilterImpl filter);
}
