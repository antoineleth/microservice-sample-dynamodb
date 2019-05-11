package apenaleth.microservicedynamo.db.dynamodb;


import apenaleth.microservicedynamo.db.entity.BookEntity;

import java.util.List;

/**
 * Repository for Book Entity
 *
 */
public interface BookRepository {

    /**
     * Get a list of books
     *
     * @return
     */
    List<BookEntity> getBooks();

    /**
     * Get a book by ID
     *
     * @param bookId
     * @return
     */
    BookEntity getBookById(String bookId);

    /**
     * Save a book
     *
     * @param book
     */
    void saveBook(BookEntity book);
}
