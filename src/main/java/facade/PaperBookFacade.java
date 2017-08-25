package facade;

import entity.PaperBook;

import javax.persistence.EntityManager;

/**
 * Created by adam on 8/25/2017.
 */
public class PaperBookFacade extends Facade {
    public PaperBookFacade(EntityManager em) {
        super(em);
    }

    public void savePaperBook(PaperBook paperBook) {
        persist(paperBook);
    }

    public void deletePaperBook(String id) {
        PaperBook paperBook = getPaperBook(id);
        delete(paperBook);
    }

    public PaperBook getPaperBook(String id) {
        return em.find(PaperBook.class, id);
    }
}
