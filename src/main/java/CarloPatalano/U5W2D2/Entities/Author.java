package CarloPatalano.U5W2D2.Entities;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class Author {
    private Long id;
    private String name;
    private String cognome;
    private String email;
    private String dataDiNascita;
    private String avatar;

    public Author(long id, String nome, String cognome, String email, String dataDiNascita, String avatar) {
        this.id = id;
        this.name = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;;
    }
}
