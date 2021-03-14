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
public class Category extends ModelImpl {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Nome é obrigatório")
	@NotEmpty(message = "Nome é obrigatório")
	@Size(min = 3, max = 250, message = "Nome deve conter de 3 a 250 caracteres!")
	@Column(nullable = false, length = 250)
	private String name;
	
	@NotNull(message = "Cor é obrigatório")
	@NotEmpty(message = "Cor é obrigatório")
	@Size(min = 3, max = 7, message = "A cor deve conter de 3 a 7 caracteres!")
	@Column(nullable = false, length = 7)
	private String color;
	
	@NotNull(message = "O ícone é obrigatório")
	@NotEmpty(message = "O ícone é obrigatório")
	@Size(min = 3, max = 250, message = "O ícone deve conter de 3 a 250 caracteres!")
	@Column(nullable = false, length = 250)
	private String icon;
}
