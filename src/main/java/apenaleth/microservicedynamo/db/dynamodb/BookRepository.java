package apenaleth.microservicedynamo.db.dynamodb;


import apenaleth.microservicedynamo.db.entity.BookEntity;

import java.util.List;

public interface BookRepository {

    List<BookEntity> getBooks();

    BookEntity getBookById(String bookId);

    void postBook(BookEntity book);
}
