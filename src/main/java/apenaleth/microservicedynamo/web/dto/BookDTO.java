package apenaleth.microservicedynamo.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonPropertyOrder({"isbn", "title", "author", "theme"})
public class BookDTO implements Serializable {

    @JsonProperty(value = "isbn")
    private String isbn;

    @JsonProperty(value = "author")
    private String author;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "theme")
    private String theme;

}