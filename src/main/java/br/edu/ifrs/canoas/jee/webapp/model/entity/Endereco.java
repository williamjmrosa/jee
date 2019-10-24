package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * Entity implementation class for Entity: Endereco
 *
 */
@Entity
@Data
public class Endereco extends BaseEntity<Long> implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String logradouro;
	private int numero;
	private String cep;
	private String cidade;
	private String estado;
	@OneToOne (mappedBy = "endereco")
	private Usuario usuario;
   
}
