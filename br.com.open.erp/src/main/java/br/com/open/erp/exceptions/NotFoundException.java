package br.com.open.erp.exceptions;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(Long id) {
		super("Não foram encontrado resultados para o código " +  id);
	}

}
