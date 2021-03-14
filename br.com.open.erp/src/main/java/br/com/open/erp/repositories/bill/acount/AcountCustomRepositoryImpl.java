package br.com.open.erp.repositories.bill.acount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.EntityPathBase;

import br.com.open.erp.models.bill.Acount;
import br.com.open.erp.models.bill.QAcount;
import br.com.open.erp.repositories.RepositoryImpl;

@Repository
@Primary
public class AcountCustomRepositoryImpl extends RepositoryImpl<Acount> implements AcountCustomRepository {

	@Override
	public EntityPathBase<Acount> getEntity() {
		return QAcount.acount;
	}

}
