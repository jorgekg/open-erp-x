package br.com.open.erp.models.bill;

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
public class Acount extends ModelImpl {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "O nome é obrigatório")
	@NotEmpty(message = "O nome é obrigatório")
	@Size(min = 3, max = 100, message = "O nome deve conter de 3 a 100 caracteres!")
	@Column(nullable = false, length = 100 )
	private String name;

	@NotNull(message = "Cor é obrigatório")
	@NotEmpty(message = "Cor é obrigatório")
	@Size(min = 3, max = 7, message = "A cor deve conter de 3 a 7 caracteres!")
	@Column(nullable = false, length = 7)
	private String color;

	
	@Column(nullable = true)
	private String number;
}
