package br.com.open.erp.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;

import br.com.open.erp.exceptions.BadRequestException;
import br.com.open.erp.exceptions.NotFoundException;
import br.com.open.erp.models.configuration.User;
import br.com.open.erp.services.configuration.UserService;
import br.com.open.erp.utils.FilterImpl;
import br.com.open.erp.utils.FilterQueryImpl;
import br.com.open.erp.utils.Page;

@Repository
public abstract class RepositoryImpl<T> implements br.com.open.erp.repositories.Repository<T> {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserService userService;

	public abstract EntityPathBase<T> getEntity();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T retrieve(Long id) {

		JPAQueryBase base = new JPAQuery<T>(em).from(getEntity());

		User user = userService.getActiveUser();
		try {
			if (user != null && user.getCompanyId() != null) {
				NumberPath<Long> companyId = (NumberPath<Long>) getEntity().getClass().getField("companyId")
						.get(getEntity());
				base.where(companyId.eq(companyId));
			}
			NumberPath<Long> qId = (NumberPath<Long>) getEntity().getClass().getField("id").get(getEntity());
			base.where(qId.eq(id));
		} catch (Exception e) {
			throw new RuntimeException();
		}
		List<T> entity = base.fetch();
		if (entity != null && !entity.isEmpty()) {
			return entity.get(0);
		}
		throw new NotFoundException(id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page<T> list(FilterImpl filter) {

		JPAQueryBase base = new JPAQuery<T>(em).from(getEntity());

		try {
			for (FilterQueryImpl query : filter.getFilter()) {

				if (query.getBoolValue() != null) {
					BooleanPath value = (BooleanPath) getEntity().getClass().getField(query.getField())
							.get(getEntity());
					base.where(value.eq(query.getBoolValue()));
				}
				if (query.getLongValue() != null) {
					NumberPath<Long> value = (NumberPath<Long>) getEntity().getClass().getField(query.getField())
							.get(getEntity());
					switch (query.getType()) {
					case EQ:
						base.where(value.eq(query.getLongValue()));
						break;
					case MORE:
						base.where(value.gt(query.getLongValue()));
						break;
					case EQMORE:
						base.where(value.goe(query.getLongValue()));
						break;
					case LESS:
						base.where(value.lt(query.getLongValue()));
						break;
					case EQLESS:
						base.where(value.loe(query.getLongValue()));
						break;
					default:
						throw new BadRequestException("Modificador incorreto");
					}
				}
				if (query.getDateValue() != null) {
					DateTimePath<Date> value = (DateTimePath<Date>) getEntity().getClass().getField(query.getField())
							.get(getEntity());
					switch (query.getType()) {
					case EQ:
						base.where(value.eq(query.getDateValue()));
						break;
					case MORE:
						base.where(value.gt(query.getDateValue()));
						break;
					case EQMORE:
						base.where(value.goe(query.getDateValue()));
						break;
					case LESS:
						base.where(value.lt(query.getDateValue()));
						break;
					case EQLESS:
						base.where(value.loe(query.getDateValue()));
						break;
					default:
						throw new BadRequestException("Modificador incorreto");
					}
				}
				if (query.getStringValue() != null) {
					StringPath value = (StringPath) getEntity().getClass().getField(query.getField()).get(getEntity());
					switch (query.getType()) {
					case EQ:
						base.where(value.eq(query.getStringValue()));
						break;
					case MORE:
						base.where(value.gt(query.getStringValue()));
						break;
					case EQMORE:
						base.where(value.goe(query.getStringValue()));
						break;
					case LESS:
						base.where(value.lt(query.getStringValue()));
						break;
					case EQLESS:
						base.where(value.loe(query.getStringValue()));
						break;
					case LIKE:
						base.where(value.containsIgnoreCase(query.getStringValue()));
						break;
					default:
						throw new BadRequestException("Modificador incorreto");
					}
				}
			}
		} catch (NoSuchFieldException e) {
			throw new BadRequestException("Verifique os filtros e tente novamente!");
		} catch (Exception e) {
			throw new RuntimeException();
		}

		try {
			User user = userService.getActiveUser();
			if (user != null && user.getCompanyId() != null) {
				NumberPath<Long> companyId = (NumberPath<Long>) getEntity().getClass().getField("companyId")
						.get(getEntity());
				base.where(companyId.eq(companyId));
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}

		base.limit(filter.getSize() != null ? filter.getSize() : 10);
		base.offset(filter.getPage() != null ? filter.getSize() * filter.getPage() : 0);

		Long quantity = base.fetchCount();

		List<T> entity = base.fetch();
		return new Page<>(entity, quantity, quantity / filter.getSize() + 1);
	}

}
