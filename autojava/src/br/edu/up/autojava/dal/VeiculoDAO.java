package br.edu.up.autojava.dal;

import java.util.List;
import javax.persistence.EntityManager;

import br.edu.up.autojava.model.Veiculo;
import javax.persistence.NoResultException;

public class VeiculoDAO implements DAO<Veiculo> {
	
	// adiciona um novo registro de veiculo
	public boolean adicionar(Veiculo o) {
		try {
			// verifica se o veiculo é valido
			if(o.validate()) {				
				EntityManager em = Conexao.getEntityManager();
				em.getTransaction().begin();
				em.persist(o);
				em.getTransaction().commit();
				return true;
			}
		
		}catch(Exception e) {
			System.out.println("ERRO: " + e);
		}

		return false;
	}

	// busca um veiculo cadastrado na base
	public Veiculo buscar(Integer id) {
		try {
			// valida se o id nao e nulo
			if(id == null) {
				return null;
			}
			
			EntityManager em = Conexao.getEntityManager();
			Veiculo o = em.find(Veiculo.class, id);
			return o;
		
		}catch(NoResultException e) {
			return null;
		}
	}

	// lista todos os veiculos cadastrados
	@SuppressWarnings("unchecked")
	public List<Veiculo> listar() {
		try {
			EntityManager em = Conexao.getEntityManager();
			return (List<Veiculo>)em.createQuery("SELECT v FROM Veiculo v").getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	// altera um registro de veiculo
	public boolean alterar(Veiculo o) {
		try {
			// verifica se o veiculo é valido
			if(o.validate()) {				
				EntityManager em = Conexao.getEntityManager();
				em.getTransaction().begin();
				em.merge(o);
				em.getTransaction().commit();
				return true;
			}
		}catch (Exception e) {
			System.out.println("ERRO: " + e);
		}

		return false;
	}

	// remove um registro de veiculo
	public boolean remover(Veiculo o) {
		try {
			
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.getReference(Veiculo.class, o.getId()));
			em.getTransaction().commit();
			return true;
		
		}catch(Exception e) {
			System.out.println("ERRO: " + e);
		}

		return false;
	}
}
