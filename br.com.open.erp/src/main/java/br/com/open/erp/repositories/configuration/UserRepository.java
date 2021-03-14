package br.com.open.erp.repositories.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.open.erp.models.configuration.User;

@Repository
public interface UserRepository extends UserCustomRepository, JpaRepository<User, Long> {

}
