package CarloPatalano.ExamU6D5.Services;

import CarloPatalano.ExamU6D5.Entities.Postazione;
import CarloPatalano.ExamU6D5.Entities.Prenotazione;
import CarloPatalano.ExamU6D5.Entities.Utente;
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
            throw new Exception("La postazione è già prenotata per questa data.");
        }
        if (hasUserAlreadyBooked(prenotazione.getUtente(), prenotazione.getDate())) {
            throw new Exception("L'utente ha già una prenotazione per questa data.");
        }

        return prenotazioneRepository.save(prenotazione);
    }
    public boolean hasUserAlreadyBookedInDifferentPostazione(Utente utente, LocalDate date) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByUtenteAndDate(utente, date);
        if (prenotazioni.isEmpty()) {
            return false;
        }

        Set<Postazione> bookedPostazioni = new HashSet<>();
        for (Prenotazione prenotazione : prenotazioni) {
            bookedPostazioni.add(prenotazione.getPostazione());
        }

        return bookedPostazioni.size() > 1;
    }
}
