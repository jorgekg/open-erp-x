package br.com.open.erp.models.configuration;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.types.dsl.EntityPathBase;

import br.com.open.erp.models.Model;
import br.com.open.erp.models.ModelImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends ModelImpl implements Model<User> {

	private static final long serialVersionUID = 1L;
	
	
	@NotNull(message = "Informe um nome")
	@NotEmpty(message = "Informe um nome")
	@Size(min = 1, max = 200, message = "O nome deve conter de 1 a 200 caracteres")
	private String name;
	
	@NotNull(message = "Informe um e-mail")
	@NotEmpty(message = "Informe um e-mail")
	@Size(min = 1, max = 250, message = "O e-mail deve conter de 1 a 250 caracteres")
	private String email;
	
	@NotNull(message = "Informe uma senha")
	@NotEmpty(message = "Informe uma senha")
	@Size(min = 1, max = 300, message = "A senha deve conter de 1 a 300 caracteres")
	private String password;

	@JsonIgnore
	@Override
	public EntityPathBase<User> getQEntity() {
		return QUser.user;
	}

}
