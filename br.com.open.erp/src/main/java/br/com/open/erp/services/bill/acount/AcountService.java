package br.com.open.erp.services.bill.acount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.open.erp.models.bill.Acount;
import br.com.open.erp.repositories.bill.acount.AcountRepository;
import br.com.open.erp.services.ServiceImpl;

@Service
public class AcountService extends ServiceImpl<Acount>{

	@Autowired
	private AcountRepository acountRepository;
	
	@Override
	public JpaRepository<Acount, Long> getRepository() {
		return acountRepository;
	}

	@Override
	public void validator(Acount entity) {
		
	}

}
