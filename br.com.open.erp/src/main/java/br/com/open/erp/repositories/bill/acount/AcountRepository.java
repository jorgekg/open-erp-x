package br.com.open.erp.repositories.bill.acount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.open.erp.models.bill.Acount;

@Repository
public interface AcountRepository extends JpaRepository<Acount, Long>, AcountCustomRepository {

}
