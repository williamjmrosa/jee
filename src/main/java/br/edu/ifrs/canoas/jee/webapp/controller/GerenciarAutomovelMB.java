package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Automovel;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarAutomovelService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarUsuarioService;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarAutomovelMB {

	@Inject
	private GerenciarAutomovelService gerenciarAutomovelService;
	@Inject
	private Automovel automovel;
	
	private List<Automovel> automoveis;
	
	@PostConstruct
	public void init() {
		automoveis = gerenciarAutomovelService.busca(null);
	}
	
	public String salva() {
		gerenciarAutomovelService.salvaAutomovel(automovel);
		this.init();
		return limpa();
	}
	
	public void edita(Automovel a) {
		this.automovel = a;
	}
	
	public void exclui() {
		gerenciarAutomovelService.exclui(automovel);
		this.init();
	}
	
	public String limpa() {
		automovel = new Automovel();
		return "/public/automovel.jsf?facesRedirect=true";
	}

}
