package br.com.open.erp.controllers.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.open.erp.controllers.ControllerImpl;
import br.com.open.erp.models.configuration.User;
import br.com.open.erp.services.Service;
import br.com.open.erp.services.configuration.UserService;

@RestController
@RequestMapping("/configurations/users")
public class UserController extends ControllerImpl<User> {
	
	@Autowired
	private UserService service;

	@Override
	public Service<User> getService() {
		return service;
	}

}
