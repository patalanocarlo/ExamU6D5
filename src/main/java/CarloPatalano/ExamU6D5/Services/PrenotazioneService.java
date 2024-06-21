package CarloPatalano.ExamU6D5.Services;

import CarloPatalano.ExamU6D5.Entities.Postazione;
import CarloPatalano.ExamU6D5.Entities.Prenotazione;
import CarloPatalano.ExamU6D5.Entities.TipoPostazione;
import CarloPatalano.ExamU6D5.Entities.Utente;
import CarloPatalano.ExamU6D5.Repository.PostazioneRepository;
import CarloPatalano.ExamU6D5.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;
    public boolean isPostazioneAvailable(Postazione postazione, LocalDate date) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndDate(postazione, date);
        return prenotazioni.isEmpty();
    }

    public boolean hasUserAlreadyBooked(Utente utente, LocalDate date) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByUtenteAndDate(utente, date);
        return !prenotazioni.isEmpty();
    }

    public Prenotazione createPrenotazione(Prenotazione prenotazione) throws Exception {
        if (!isPostazioneAvailable(prenotazione.getPostazione(), prenotazione.getDate())) {
            throw new Exception("Non puoi prenotare due volte per la stessa postazione nello stesso giorno");
        }
        return prenotazioneRepository.save(prenotazione);
    }
    public boolean hasUserAlreadyBookedInDifferentPostazione(Utente utente, LocalDate date, Postazione postazione) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByUtenteAndDate(utente, date);
        return prenotazioni.stream().anyMatch(prenotazione -> !prenotazione.getPostazione().equals(postazione));
    }
    public List<Postazione> findPostazioniByTipoAndCitta(TipoPostazione tipoPostazione, String citta) {
        List<Postazione> postazioni = postazioneRepository.findByTipoPostazioneAndCitta(tipoPostazione, citta);
        return postazioni;
    }
}
