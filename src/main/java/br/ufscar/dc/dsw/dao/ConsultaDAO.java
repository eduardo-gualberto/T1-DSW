package br.ufscar.dc.dsw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.ufscar.dc.dsw.domain.Consulta;

public class ConsultaDAO extends GenericDAO<Consulta>{

	@Override
	public Consulta find(Long id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Consulta consulta = em.find(Consulta.class, id);
		tx.commit();
		em.close();
		return consulta;
	}

	@Override
	public List<Consulta> findAll() {
		EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT c FROM Consulta c");
        List<Consulta> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
	}

	@Override
	public void create(Consulta t) {
		if(!this.validarData(t)) {
			return;
		}
		EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
        em.close();
	}

	@Override
	public void update(Consulta t) {
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
        Consulta c = em.getReference(Consulta.class, id);
        tx.begin();
        em.remove(c);
        tx.commit();
        em.close();		
	}

	public List<Consulta> findByCPF(String CPF) {
		EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT c FROM Consulta c WHERE c.CPF_profissional = :cpf1 OR c.CPF_cliente = :cpf2");
        q.setParameter("cpf1", CPF);
        q.setParameter("cpf2", CPF);
        List<Consulta> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
	}
	
	private boolean validarData(Consulta t) {
		String data = this.data_hora(t);
		List<Consulta> consultas = this.findAll();
		for(Consulta curr: consultas) {
			String dataCurr = this.data_hora(curr);
			if(data.equals(dataCurr)) {
				return false;
			}
		}
		return true;
	}
	
	private String data_hora(Consulta t) {
		//Partindo do formato de data = "DD/MM/AAAA hh:mm"
		int hora_offset = 13;
		String data_raw = t.getData_hora();
		String data = data_raw.substring(0, hora_offset + 1);
		return data;
	}
}
