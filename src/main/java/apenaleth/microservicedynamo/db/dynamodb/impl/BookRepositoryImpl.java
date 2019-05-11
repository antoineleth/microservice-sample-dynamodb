package apenaleth.microservicedynamo.db.dynamodb.impl;

import apenaleth.microservicedynamo.db.dynamodb.BookRepository;
import apenaleth.microservicedynamo.db.entity.BookEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public List<BookEntity> getBooks() {
        return (List<BookEntity>) dynamoDBMapper.scanPage(BookEntity.class, new DynamoDBScanExpression().withLimit(50));
    }

    @Override
    public BookEntity getBookById(String bookId) {
        return dynamoDBMapper.load(BookEntity.class, bookId);
    }

    @Override
    public void saveBook(BookEntity book) {
        dynamoDBMapper.save(book);
    }
}
