package br.edu.ifrs.canoas.jee.webapp.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifrs.canoas.jee.webapp.model.dao.AutomovelDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.UsuarioDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Automovel;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

@Stateless
public class GerenciarAutomovelService {

	@Inject
	private AutomovelDAO automovelDAO;

	@Inject
	private Logger log;

	

}