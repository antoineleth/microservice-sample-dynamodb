package apenaleth.microservicedynamo.core.impl;

import apenaleth.microservicedynamo.core.BookService;
import apenaleth.microservicedynamo.db.dynamodb.BookRepository;
import apenaleth.microservicedynamo.db.entity.BookEntity;
import apenaleth.microservicedynamo.web.dto.BookDTO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Log4j2
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BookDTO> getBooks() {

        List<BookEntity> books = bookRepository.getBooks();

        if (books == null) {
            return null;
        }

        return modelMapper.map(books, (Type) BookEntity.class);
    }

    @Override
    public BookDTO getBookById(String bookId) {

        log.info("Retrieving book by id: {}", bookId);
        BookEntity bookEntity = bookRepository.getBookById(bookId);

        if (bookEntity == null) {
            return null;
        }

        return modelMapper.map(bookEntity, BookDTO.class);
    }

    @Override
    public void postBook(BookDTO bookDTO) {

        // TODO check if already exists, do the check by dynamo or by java.

        log.info("Saving book by id: {}", bookDTO.getIsbn());
        bookRepository.saveBook(modelMapper.map(bookDTO, BookEntity.class));
    }

    @Override
    public void putBook(String bookId, BookDTO bookDTO) throws Exception {

        bookDTO.setIsbn(bookId);

        BookEntity alreadySaved = modelMapper.map(bookRepository.getBooks(), (Type) BookEntity.class);

        if (alreadySaved == null) {
            // TODO Change to customized exception
            throw new Exception("not found");
        }

        BookEntity bookEntity = modelMapper.map(bookDTO, BookEntity.class);

        if (alreadySaved.equals(bookEntity)) {
            // TODO Change to customized exception
            throw new Exception("not modified");
        }

        log.info("Saving book by id: {}", bookId);

        bookRepository.saveBook(bookEntity);
    }
}