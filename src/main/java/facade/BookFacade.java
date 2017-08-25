package facade;

import entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by adam on 8/25/2017.
 */
public class BookFacade extends Facade {
    public BookFacade(EntityManager em) {
        super(em);
    }

    public List<Book> getAllBooks() {
        Query query = em.createQuery("SELECT u FROM Book u");
        return query.getResultList();
    }
}
