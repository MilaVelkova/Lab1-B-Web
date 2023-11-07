package mk.finki.ukim.wp.lab.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
    private long id;
    private String name;
    private String surname;
    private String biography;
}
