package apenaleth.microservicedynamo.core.impl;

import apenaleth.microservicedynamo.core.BookService;
import apenaleth.microservicedynamo.db.dynamodb.BookRepository;
import apenaleth.microservicedynamo.web.dto.BookDTO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public BookDTO getBookById(String bookId) {

        log.info("Retrieving book by id: {}", bookId);

        return modelMapper.map(bookRepository.getBookById(bookId), BookDTO.class);
    }

    @Override
    public void postBook(BookDTO book) {

    }
}
