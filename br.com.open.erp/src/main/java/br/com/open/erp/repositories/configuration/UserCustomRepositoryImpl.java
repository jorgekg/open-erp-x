package br.com.open.erp.repositories.configuration;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.EntityPathBase;

import br.com.open.erp.models.configuration.QUser;
import br.com.open.erp.models.configuration.User;
import br.com.open.erp.repositories.RepositoryImpl;

@Repository
@Primary
public class UserCustomRepositoryImpl extends RepositoryImpl<User> implements UserCustomRepository {

	@Override
	public EntityPathBase<User> getEntity() {
		return QUser.user;
	}

}
