package apenaleth.microservicedynamo.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@JsonPropertyOrder({"isbn", "title", "author", "theme"})
public class BookDTO implements Serializable {

    @JsonProperty(value = "isbn")
    private String isbn;

    @NotBlank
    @JsonProperty(value = "author")
    private String author;

    @NotBlank
    @JsonProperty(value = "title")
    private String title;

    @NotBlank
    @JsonProperty(value = "theme")
    private String theme;

}