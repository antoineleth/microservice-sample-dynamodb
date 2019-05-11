package apenaleth.microservicedynamo.core;

import apenaleth.microservicedynamo.web.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getBooks();

    BookDTO getBookById(String bookId);

    void postBook(BookDTO book);

    void putBook(String bookId, BookDTO bookDTO) throws Exception;
}