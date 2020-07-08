package ro.esolacad.javaspring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;

import ro.esolacad.javaspring.jpa.manytomany.Book;
import ro.esolacad.javaspring.jpa.manytomany.BookRepository;
import ro.esolacad.javaspring.jpa.manytomany.BookService;

@SpringBootTest
public class ManyToManyTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    @Sql("/sql/book_author.sql")
    @Sql(value = "/sql/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testManyToMany() {
//        Book book = bookRepository.findAll().get(0);
//        System.out.println(book.getTitle());

//        bookService.saveBook(-1L, Arrays.asList(-1L, -2L));
        bookService.saveBook2(-1L, Arrays.asList(-1L, -2L));

        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
        bookService.showBook(-1L);
    }
}
