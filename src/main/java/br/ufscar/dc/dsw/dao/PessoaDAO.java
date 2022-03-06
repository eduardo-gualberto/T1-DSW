package br.ufscar.dc.dsw.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.ufscar.dc.dsw.domain.*;

public class PessoaDAO extends GenericDAO<Pessoa>{

	@Override
	public Pessoa find(Long id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Pessoa pessoa = em.find(Pessoa.class, id);
		tx.commit();
		em.close();
		return pessoa;
	}

	@Override
	public List<Pessoa> findAll() {
	 	EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT p FROM Pessoa p");
        List<Pessoa> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
	}

	public List<Pessoa> findByEmail(String email) {
		EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT p FROM Pessoa p WHERE p.email = :email");
		q.setParameter("email", email);
        List<Pessoa> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
	}
	
	@Override
	public void create(Pessoa t) {
		EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
        em.close();		
	}

	@Override
	public void update(Pessoa t) {
		EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(t);
        tx.commit();
        em.close();		
	}

	@Override
	public void delete(Long id) {
		EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Pessoa pessoa = em.getReference(Pessoa.class, id);
        tx.begin();
        em.remove(pessoa);
        tx.commit();
        em.close();		
	}

}
