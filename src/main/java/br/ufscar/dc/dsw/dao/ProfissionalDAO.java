package br.ufscar.dc.dsw.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.ufscar.dc.dsw.domain.*;

public class ProfissionalDAO extends PessoaDAO{
	public List<Profissional> findByAreaConhecimento(String areaConhecimento) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String jpql = "SELECT p FROM Profissional p where p.area_conhecimento = :areaConhecimento";
		TypedQuery<Profissional> q = em.createQuery(jpql, Profissional.class);
		q.setParameter("areaConhecimento", areaConhecimento);
		List<Profissional> lista = q.getResultList();
		tx.commit();
		em.close();
		return lista;
	}
	public List<Profissional> findByEmailProfissional(String email) {
		List<Pessoa> p = super.findByEmail(email);
		if(p.isEmpty()) {
			List<Profissional> empty = new ArrayList<Profissional>();
			return empty;
		}
		EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT p FROM Profissional p WHERE p.id= :id");
		q.setParameter("id", p.remove(0).getId());
        List<Profissional> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
	}
	
	public List<Profissional> findAllProfissional() {
	 	EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT p FROM Profissional p");
        List<Profissional> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
	}
}
