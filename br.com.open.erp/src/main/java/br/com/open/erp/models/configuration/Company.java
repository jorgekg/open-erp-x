package br.com.open.erp.models.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class Company extends ModelImpl {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Nome é obrigatório")
	@NotEmpty(message = "Nome é obrigatório")
	@Size(min = 3, max = 250, message = "Nome deve conter de 3 a 250 caracteres!")
	@Column(nullable = false)
	private String name;
	
	private String socialName;
	
	private String phone;
	
	private String state;
	
	private String city;
	
	private String province;
	
	private String street;
	
	private String number;

}
