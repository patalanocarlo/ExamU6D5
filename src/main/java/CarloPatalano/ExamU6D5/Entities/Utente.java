package CarloPatalano.ExamU6D5.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String nomeCompleto;
    private String email;

    public Utente(String email, String nomeCompleto, String username) {
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.username = username;
    }
}
