package org.luiz.condominio.factory;

import javax.persistence.*;

import org.apache.log4j.BasicConfigurator;

/**
 * @author luizantonioalmeida
 *
 */
@PersistenceContext 
public final class JpaFactory {

    private static EntityManagerFactory fabrica;
	private static final EntityManager entityManager;
  
    static {
        BasicConfigurator.configure();
		fabrica = Persistence.createEntityManagerFactory("condominiu");
		entityManager = fabrica.createEntityManager();
    }
    
    public static EntityManager getEntityManager(){
    	return entityManager;
    }
}
