package br.ufscar.dc.dsw.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.ufscar.dc.dsw.domain.*;

public class ClientDAO extends PessoaDAO{
	public List<Cliente> findByEmailCliente(String email) {
		List<Pessoa> p = super.findByEmail(email);
		if(p.isEmpty()) {
			List<Cliente> empty = new ArrayList<Cliente>();
			return empty;
		}
		EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.id= :id");
		q.setParameter("id", p.remove(0).getId());
        List<Cliente> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
	}
}
