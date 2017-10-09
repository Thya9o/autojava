package br.edu.up.autojava.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	private static final EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("autosolutions-java");
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}

}
