package br.com.open.erp.controllers.bill.acount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.open.erp.controllers.ControllerImpl;
import br.com.open.erp.models.bill.Acount;
import br.com.open.erp.services.Service;
import br.com.open.erp.services.bill.acount.AcountService;

@RestController
@RequestMapping("/bills/acounts")
public class AcountController extends ControllerImpl<Acount> {

	@Autowired
	private AcountService acountService;
	
	@Override
	public Service<Acount> getService() {
		return acountService;
	}

}
