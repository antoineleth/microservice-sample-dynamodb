package apenaleth.microservicedynamo.db.dynamodb.impl;

import apenaleth.microservicedynamo.db.dynamodb.BookRepository;
import apenaleth.microservicedynamo.db.entity.BookEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public List<BookEntity> getBooks() {
        return null;
    }

    @Override
    public BookEntity getBookById(String bookId) {

        BookEntity item = dynamoDBMapper.load(BookEntity.class, bookId);

        return item;
    }

    @Override
    public void postBook(BookEntity book) {

    }
}
