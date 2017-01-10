package org.luiz.condominio.factory;

import javax.persistence.*;

/**
 * @author luizantonioalmeida
 *
 */
@PersistenceContext 
public final class JpaFactory {

    private static EntityManagerFactory fabrica;
	private static final EntityManager entityManager;
  
    static {
		fabrica = Persistence.createEntityManagerFactory("condominio");
		entityManager = fabrica.createEntityManager();
    }
    
    public static EntityManager getEntityManager(){
    	return entityManager;
    }
}
