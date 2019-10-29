package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

import lombok.AllArgsConstructor.AnyAnnotation;
import lombok.Data;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Data
public class Usuario extends BaseEntity<Long> implements Serializable {
//@Pattern (regexp = "[A-z0-9]{6,8}", message = "Senha Invalida")
	
	private static final long serialVersionUID = 6262524988798723388L;

	@NotNull @Email private String email;
	@NotNull @Pattern (regexp = "[A-z0-9]{6,8}", message = "Senha Invalida")  private String senha;
	@NotNull private String nome;
	private String sobrenome;
	private String telefone;
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "id_endereco")
	private Endereco endereco = new Endereco();
}
