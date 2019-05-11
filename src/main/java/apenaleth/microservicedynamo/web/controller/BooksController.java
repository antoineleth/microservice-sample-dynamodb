package apenaleth.microservicedynamo.web.controller;

import apenaleth.microservicedynamo.core.BookService;
import apenaleth.microservicedynamo.web.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getBooks() {

        List<BookDTO> books = bookService.getBooks();

        if (CollectionUtils.isEmpty(books)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return (ResponseEntity<List<BookDTO>>) books;
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity getBook(@PathVariable @Min(1) Long bookId) {

        BookDTO bookById = bookService.getBookById(String.valueOf(bookId));

        if (bookById == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(bookById, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postBook(@RequestBody BookDTO bookDTO) {
        bookService.postBook(bookDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putBook(@PathVariable String bookId, @RequestBody BookDTO bookDTO) {
        try {
            bookService.putBook(bookId, bookDTO);
        } catch (Exception e) {
            //TODO check exception code to give the correct HTTP_STATUS as response
        }
    }
}