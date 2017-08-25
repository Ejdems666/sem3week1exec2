package facade;

import entity.EBook;

import javax.persistence.EntityManager;

/**
 * Created by adam on 8/25/2017.
 */
public class EBookFacade extends Facade {
    public EBookFacade(EntityManager em) {
        super(em);
    }

    public void saveEBook(EBook EBook) {
        persist(EBook);
    }

    public void deleteEBook(String id) {
        EBook EBook = getEBook(id);
        delete(EBook);
    }

    public EBook getEBook(String id) {
        return em.find(EBook.class, id);
    }
}
