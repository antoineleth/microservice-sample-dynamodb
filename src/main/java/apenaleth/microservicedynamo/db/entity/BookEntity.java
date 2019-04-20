package apenaleth.microservicedynamo.db.entity;

import apenaleth.microservicedynamo.util.Constants;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

import java.io.Serializable;

@Data
@DynamoDBTable(tableName = Constants.DDB_BOOKS_TABLE)
public class BookEntity implements Serializable {

    @DynamoDBHashKey(attributeName = "isbn")
    private String isbn;

    @DynamoDBAttribute(attributeName = "author")
    private String author;

    @DynamoDBAttribute(attributeName = "title")
    private String title;

    @DynamoDBAttribute(attributeName = "theme")
    private String theme;

}
