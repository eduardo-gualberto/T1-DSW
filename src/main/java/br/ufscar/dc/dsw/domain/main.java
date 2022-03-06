package br.ufscar.dc.dsw.domain;
import java.util.List;

import br.ufscar.dc.dsw.dao.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProfissionalDAO pDAO = new ProfissionalDAO();
		Pessoa p = new Profissional("eduardo", "12345678910", "eduardo@email.com", "123", "medicina", "dermatologia", "C");
		pDAO.create(p);
		List<Pessoa> l = pDAO.findAll();
		System.out.println(l);
		ProfissionalDAO.close();
	}

}
