package br.edu.up.autojava.dal;

import java.util.List;
import javax.persistence.EntityManager;

import br.edu.up.autojava.model.Cliente;
import javax.persistence.NoResultException;

public class ClienteDAO implements Dao<Cliente> {

	// adiciona um novo registro de cliente
	public boolean adicionar(Cliente o) {
		try {
			
			// verifica se o cliente é valido
			if(o.validate()) {			
				EntityManager em = Conexao.getEntityManager();
				em.getTransaction().begin();
				em.persist(o);
				em.getTransaction().commit();
				return true;
			}
		
		}catch (Exception e) {
			System.out.println("ERRO: " + e);
		}

		return false;
	}

	// busca um cliente cadastrado na base
	public Cliente buscar(Integer id) {
		try {
			// valida se o id nao e nulo
			if(id == null) {
				return null;
			}
			
			EntityManager em = Conexao.getEntityManager();
			return em.find(Cliente.class, id);
			
		}catch (NoResultException e) {
			return null;
		}
	}
	
	// lista todos os clientes cadastrados
	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		try {
			EntityManager em = Conexao.getEntityManager();
			return (List<Cliente>)em.createQuery("SELECT c FROM Cliente c").getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	// altera um registro de cliente
	public boolean alterar(Cliente o) {
		try {
		
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
	
	// remove um registro de cliente
	public boolean remover(Cliente o) {
		try {
		
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.getReference(Cliente.class, o.getId()));
			em.getTransaction().commit();
			return true;
		
		}catch(Exception e) {
			System.out.println("ERRO: " + e);
		}

		return false;
	}
}
