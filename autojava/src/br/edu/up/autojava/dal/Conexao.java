package br.edu.up.autojava.dal;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Conexao {
	
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("autojava");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
