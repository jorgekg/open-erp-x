package br.com.open.erp.models;

import com.querydsl.core.types.dsl.EntityPathBase;

import br.com.open.erp.models.configuration.User;

public interface Model<T> {

	public EntityPathBase<User> getQEntity();
}
