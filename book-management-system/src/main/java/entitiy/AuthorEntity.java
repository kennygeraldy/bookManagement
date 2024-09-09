package entitiy;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "author")
@Getter
@Setter

public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "author", nullable = false)
    @JsonProperty("author")
    private String author;


    @Column( name = "bio")
    @JsonProperty("bio")
    private String bio;
}
