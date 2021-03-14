package br.com.open.erp.controllers;

import org.springframework.http.ResponseEntity;

import br.com.open.erp.utils.Page;

public interface Controller<T> {

	ResponseEntity<T> retrieve(Long id);
	ResponseEntity<Page<T>> list(String filter, Integer size, Integer page, String order);
	ResponseEntity<T> create(T entity);
	ResponseEntity<T> update(Long id, T entity);
	ResponseEntity<?> delete(Long id);
	
}
