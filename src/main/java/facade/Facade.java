package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by adam on 8/25/2017.
 */
public abstract class Facade {
    protected EntityManager em;

    public Facade(EntityManager em) {
        this.em = em;
    }

    protected void persist(Object entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        em.flush();
        transaction.commit();
    }

    protected void delete(Object entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(entity);
        em.flush();
        transaction.commit();
    }
}
