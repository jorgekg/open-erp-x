package br.com.open.erp.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.open.erp.services.Service;
import br.com.open.erp.utils.FilterImpl;
import br.com.open.erp.utils.Page;

public abstract class ControllerImpl<T> implements Controller<T> {

	public abstract Service<T> getService();

	@PostMapping
	@Override
	public ResponseEntity<T> create(@Valid @RequestBody T entity) {
		return ResponseEntity.ok().body(getService().create(entity));
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<T> update(@PathVariable(required = true) Long id, @Valid @RequestBody T entity) {
		return ResponseEntity.ok().body(getService().update(id, entity));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<?> delete(@PathVariable(required = true) Long id) {
		getService().delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<T> retrieve(@PathVariable(required = true) Long id) {
		return ResponseEntity.ok().body(getService().retrieve(id));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<T>> list( //
			@RequestParam(defaultValue = "") String filter, //
			@RequestParam(defaultValue = "10") Integer size, //
			@RequestParam(defaultValue = "0") Integer page, //
			@RequestParam(defaultValue = "") String order //
	) {
		return ResponseEntity.ok().body(getService().list(FilterImpl.parse(filter, size, page, order)));
	}

}
