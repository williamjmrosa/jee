package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Entity implementation class for Entity: Automovel
 *
 */
@Entity
@Data
public class Automovel extends BaseEntity<Long> implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@NotNull private String marca;
	@NotNull private String modelo;
	@NotNull private int ano;
	@NotNull private String placa;
	@NotNull private String RENAVAN;
	private Date data;
	
	public String getDataFormatada(){
		String dt;
		if(data != null) {
			dt = data.toString().substring(0,10);
		}else {
			dt = " ";
		}
		return dt;
		   
	}
   
}
