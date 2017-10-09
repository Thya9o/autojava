package br.edu.up.autojava.dal;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import br.edu.up.autojava.model.Cliente;
import javax.persistence.NoResultException;

public class ClienteDAO {

	public static boolean adicionar(Cliente cliente) {
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			System.out.println("ERRO: " + e);
			return false;
		}
	}

	public static Cliente buscar(int id) {
		try{
			EntityManager em = Conexao.getEntityManager();
			Cliente cliente = em.find(Cliente.class, id);
			return cliente;
		}catch (NoResultException e) {
			return null;
		}
	}

	public static List<Cliente> listar() {
		try{
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createNativeQuery("SELECT * FROM clientes", Cliente.class);
			@SuppressWarnings("unchecked")
			List<Cliente> lista = q.getResultList();
			return lista;
		}catch (NoResultException e) {
			return null;
		}
	}

	public static boolean alterar(Cliente cliente) {
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch (Exception e) {
			System.out.println("ERRO: " + e);
			return false;
		}
	}

	public static boolean remover(Cliente cliente) {
		
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(Cliente.class, cliente.getId()));
			em.getTransaction().commit();
			em.close();
			return true;
		}catch (Exception e) {
			System.out.println("ERRO: " + e);
			return false;
		}
	}
	
}
