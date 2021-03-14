package br.com.open.erp.services.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.open.erp.models.configuration.User;
import br.com.open.erp.repositories.configuration.UserRepository;
import br.com.open.erp.services.ServiceImpl;

@Service
public class UserService extends ServiceImpl<User> {

	@Autowired
	private UserRepository repository;

	public User getActiveUser() {
		User u = new User("Jorge", "", "");
		u.setCompanyId(1L);
		return u;
	}

	@Override
	public JpaRepository<User, Long> getRepository() {
		return repository;
	}

	@Override
	public void validator(User user) {
	}

}
