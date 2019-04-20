package apenaleth.microservicedynamo.web.controller;

import apenaleth.microservicedynamo.core.BookService;
import apenaleth.microservicedynamo.web.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getBooks() {
        return (ResponseEntity<List<BookDTO>>) bookService.getBooks();
    }

    @GetMapping("/book/{bookId}")
    public BookDTO getBook(@PathVariable @Min(1) Long bookId) {
        return bookService.getBookById(String.valueOf(bookId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postBook(@RequestBody BookDTO bookDTO) {
        bookService.postBook(bookDTO);
    }
}