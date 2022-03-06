package br.ufscar.dc.dsw.controller;

import java.util.List;

import br.ufscar.dc.dsw.dao.*;
import br.ufscar.dc.dsw.domain.*;

public class LogInController {
	public static int auth(String email, String psw) {
		if(email.equals("admin") && psw.equals("admin")) {
			return 2;
		}
		PessoaDAO pDAO = new PessoaDAO();
		List<Pessoa> users = pDAO.findByEmail(email);
		if(users.isEmpty()) {
			return 0;
		}
		if(users.remove(0).getSenha().equals(psw)) {
			return 1;
		}
		return 0;
	}
	
	public Cliente registerCliente(Cliente user) {
		ClientDAO cDAO = new ClientDAO();
		cDAO.create(user);
		return user;
	}
	
	public Profissional registerProfissional(Profissional user) {
		ProfissionalDAO pDAO = new ProfissionalDAO();
		pDAO.create(user);
		return user;
	}
}
