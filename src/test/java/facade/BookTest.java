package facade;

import entity.Book;
import entity.EBook;
import entity.PaperBook;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by adam on 8/25/2017.
 */
public class BookTest {
    private EntityManager em;

    public BookTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        em = entityManagerFactory.createEntityManager();
    }

    @Test
    public void testAddEbook() throws Exception {
        EBook EBook = new EBook();
        EBook.setIsbn("1-2345");
        EBook.setTitle("some title");
        EBook.setDownloadUrl("some url");
        EBook.setSizeMB(2.5);
        EBookFacade bookFacade = new EBookFacade(em);
        bookFacade.saveEBook(EBook);
    }

    @Test
    public void testAddPaperbook() throws Exception {
        PaperBook paperBook = new PaperBook();
        paperBook.setIsbn("1-2346");
        paperBook.setTitle("some title");
        paperBook.setInStock(2);
        paperBook.setShippingWeight(2.5);
        PaperBookFacade bookFacade = new PaperBookFacade(em);
        bookFacade.savePaperBook(paperBook);
    }

    @Test(priority = 1)
    public void testGetAllBooks() throws Exception {
        BookFacade bookFacade = new BookFacade(em);
        List<Book> books = bookFacade.getAllBooks();
        Assert.assertEquals(books.get(0).getClass(), EBook.class);
        Assert.assertEquals(books.get(1).getClass(), PaperBook.class);
    }

    @Test(priority = 2)
    public void testDeletePaperBook() throws Exception {
        PaperBookFacade bookFacade = new PaperBookFacade(em);
        bookFacade.deletePaperBook("1-2346");
        Assert.assertNull(bookFacade.getPaperBook("1-2346"));
    }

    @Test(priority = 2)
    public void testDeleteEbook() throws Exception {
        EBookFacade bookFacade = new EBookFacade(em);
        bookFacade.deleteEBook("1-2345");
        Assert.assertNull(bookFacade.getEBook("1-2345"));
    }

    @Override
    protected void finalize() throws Throwable {
        em.close();
    }
}