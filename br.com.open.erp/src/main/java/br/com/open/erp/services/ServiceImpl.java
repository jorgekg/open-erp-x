package br.com.open.erp.services;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.open.erp.exceptions.BadRequestException;
import br.com.open.erp.exceptions.NotFoundException;
import br.com.open.erp.models.ModelImpl;
import br.com.open.erp.models.configuration.User;
import br.com.open.erp.repositories.Repository;
import br.com.open.erp.services.configuration.UserService;
import br.com.open.erp.utils.FilterImpl;
import br.com.open.erp.utils.Page;

public abstract class ServiceImpl<T> implements Service<T> {

	@Autowired
	protected UserService userService;

	public abstract JpaRepository<T, Long> getRepository();

	public abstract void validator(T entity);

	@Transactional
	@Override
	public T create(T entity) {
		validator(entity);
		User user = userService.getActiveUser();
		if (user != null) {
			((ModelImpl) entity).setCompanyId(user.getCompanyId());
		}
		return getRepository().save(entity);
	}

	@Override
	public T update(Long id, T entity) {
		validator(entity);
		T entityFinded = get(id);
		System.out.println(entityFinded.getClass().getFields());
		for (Field fieldFinded : entityFinded.getClass().getDeclaredFields()) {
			for (Field field : entity.getClass().getDeclaredFields()) {
				if (field.getName().equals(fieldFinded.getName()) && !"id".equals(field.getName())
						&& !"serialVersionUID".equals(field.getName())) {
					fieldFinded.setAccessible(true);
					field.setAccessible(true);
					try {
						fieldFinded.set(entityFinded, field.get(entity));
					} catch (Exception e) {
						throw new BadRequestException("Verifique o campo " + field.getName());
					}
				}
			}
		}
		return getRepository().save(entityFinded);
	}

	@Transactional(readOnly = true)
	@Override
	public T get(Long id) {
		return getRepository().findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	@Override
	public void delete(Long id) {
		getRepository().delete(retrieve(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(Long id) {
		return ((Repository<T>) getRepository()).retrieve(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> list(FilterImpl filter) {
		return ((Repository<T>) getRepository()).list(filter);
	}

}
