package ro.esolacad.javaspring.jpa.manytomany;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void saveBook(Long bookId, List<Long> authorIds) {
        bookRepository.findById(bookId)
                .ifPresent(book -> {
                    Set<Author> authors = authorIds.stream()
                            .map(authorId -> Author.builder().id(authorId).build())
                            .collect(Collectors.toSet());

                    book.setAuthors(authors);

                    bookRepository.save(book);
                });
    }

    public void saveBook2(Long bookId, List<Long> authorIds) {
        bookRepository.findById(bookId)
                .ifPresent(book -> {
                    Set<Author> authors = authorIds.stream()
                            .map(authorId -> Author.builder().id(authorId).build())
                            .collect(Collectors.toSet());

                    book.setAuthors(authors);

//                    bookRepository.save(book);
                });
    }

    public void showBook(Long id) {
        bookRepository.findById(id)
        .ifPresent(book -> {
            System.out.println(book.getTitle());

            System.out.println(book.getAuthors());
        });
    }
}
