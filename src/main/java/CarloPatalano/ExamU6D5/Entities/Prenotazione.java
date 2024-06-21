package CarloPatalano.ExamU6D5.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.mapping.Join;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="Postazione_id")
    private Postazione postazione;
    @ManyToOne
    @JoinColumn(name ="utente_username")
    private  Utente utente;

    public Prenotazione(LocalDate date, Postazione postazione, Utente utente) {
        this.date = date;
        this.postazione = postazione;
        this.utente = utente;
    }
}
