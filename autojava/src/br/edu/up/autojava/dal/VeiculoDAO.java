package br.edu.up.autojava.dal;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import br.edu.up.autojava.model.Veiculo;
import javax.persistence.NoResultException;

public class VeiculoDAO {
	
	public static boolean adicionar(Veiculo veiculo) {
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.persist(veiculo);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			System.out.println("ERRO: " + e);
			return false;
		}
	}

	public static Veiculo buscar(int id) {
		try{
			EntityManager em = Conexao.getEntityManager();
			Veiculo veiculo = em.find(Veiculo.class, id);
			return veiculo;
		}catch (NoResultException e) {
			return null;
		}
	}

	public static List<Veiculo> listar() {
		try{
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createNativeQuery("SELECT * FROM veiculos", Veiculo.class);
			@SuppressWarnings("unchecked")
			List<Veiculo> lista = q.getResultList();
			return lista;
		}catch (NoResultException e) {
			return null;
		}
	}

	public static boolean alterar(Veiculo veiculo) {
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.merge(veiculo);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch (Exception e) {
			System.out.println("ERRO: " + e);
			return false;
		}
	}

	public static boolean remover(Veiculo veiculo) {
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(Veiculo.class, veiculo.getId()));
			em.getTransaction().commit();
			em.close();
			return true;
		}catch (Exception e) {
			System.out.println("ERRO: " + e);
			return false;
		}
	}

}
