package CarloPatalano.ExamU6D5.Repository;


import CarloPatalano.ExamU6D5.Entities.Postazione;
import CarloPatalano.ExamU6D5.Entities.Prenotazione;
import CarloPatalano.ExamU6D5.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository  <Prenotazione,Long> {
    List<Prenotazione> findByPostazioneAndDate(Postazione postazione, LocalDate date); // Corretto 'Data' -> 'Date'
    List<Prenotazione> findByUtenteAndDate(Utente utente, LocalDate date); // Corretto 'Data' -> 'Date'
}
