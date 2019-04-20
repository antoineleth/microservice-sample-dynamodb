package apenaleth.microservicedynamo.core.impl;

import apenaleth.microservicedynamo.core.BookService;
import apenaleth.microservicedynamo.db.dynamodb.BookRepository;
import apenaleth.microservicedynamo.web.dto.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return modelMapper.map(bookRepository.getBookById(bookId), BookDTO.class);
    }

    @Override
    public void postBook(BookDTO book) {

    }
}
