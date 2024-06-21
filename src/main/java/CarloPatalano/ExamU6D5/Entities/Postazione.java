package CarloPatalano.ExamU6D5.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private int NumeroMassimoOccupanti;

    @ManyToOne
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipoPostazione, int numeroMassimoOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.NumeroMassimoOccupanti = numeroMassimoOccupanti;
        this.edificio = edificio;
    }
}
