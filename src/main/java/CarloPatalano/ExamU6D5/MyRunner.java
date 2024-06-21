package CarloPatalano.ExamU6D5;

import CarloPatalano.ExamU6D5.Entities.*;
import CarloPatalano.ExamU6D5.Repository.EdificioRepository;
import CarloPatalano.ExamU6D5.Repository.PostazioneRepository;
import CarloPatalano.ExamU6D5.Repository.PrenotazioneRepository;
import CarloPatalano.ExamU6D5.Repository.UtenteRepository;
import CarloPatalano.ExamU6D5.Services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private EdificioRepository edificioRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {

        // Creazione e salvataggio UTENTI:
        Utente utente1 = new Utente("Patalanocarlo674@gmail.com", "Carlo Patalano", "Carlitoso94245");
        Utente utente2 = new Utente("PaoloMattera@gmail.com", "Paolo Mattera", "Paulito943e");
        Utente utente3 = new Utente("Fredefra@gmail.com", "Alfredo Vuoso", "Fredefra");
        Utente utente4 = new Utente("CrashTony@gmail.com", "Antonio Patalano", "CrashTony");
        Utente utente5 = new Utente("FedericoMessina@gmail.com", "Federico Messina", "MessisAnto5");
       // utenteRepository.saveAll(Arrays.asList(utente1, utente2, utente3, utente4, utente5));

        // Creazione e salvataggio EDIFICI:
        Edificio edificio1 = new Edificio("Edificio A", "Via Roma ", "Ischia");
        Edificio edificio2 = new Edificio("Edificio B", "Via Milano ", "Milano");
        Edificio edificio3 = new Edificio("Edificio C", "Via Scotti ", "Ischia");
        Edificio edificio4 = new Edificio("Edificio D", "Via Centrale Stazione Roma ", "Roma");
        //edificioRepository.saveAll(Arrays.asList(edificio1, edificio2, edificio3, edificio4));

        // Creazione e salvataggio POSTAZIONI:
        Postazione postazione1 = new Postazione("Postazione Privata N1", TipoPostazione.PRIVATO, 11, edificio1);
        Postazione postazione2 = new Postazione("Open Space N1", TipoPostazione.OPENSPACE, 3, edificio1);
        Postazione postazione3 = new Postazione("Sala Riunioni N1", TipoPostazione.SALA_RIUNIONI, 20, edificio2);
        Postazione postazione4 = new Postazione("Sala Riunioni N2", TipoPostazione.SALA_RIUNIONI, 12, edificio3);
        Postazione postazione5 = new Postazione("OPEN SPACE N2", TipoPostazione.OPENSPACE, 50, edificio4);
        Postazione postazione6 = new Postazione("Postazione Privata N2", TipoPostazione.PRIVATO, 9, edificio3);
        //postazioneRepository.saveAll(Arrays.asList(postazione1, postazione2, postazione3, postazione4, postazione5, postazione6));

        // Creazione e salvataggio PRENOTAZIONI con dei possibili controlli:
        try {
            Prenotazione prenotazione1 = new Prenotazione(LocalDate.now().plusDays(5), postazione1, utente1);
            prenotazioneService.createPrenotazione(prenotazione1);

            Prenotazione prenotazione2 = new Prenotazione(LocalDate.now().plusDays(1), postazione2, utente2);
            prenotazioneService.createPrenotazione(prenotazione2);

            Prenotazione prenotazione3 = new Prenotazione(LocalDate.now().plusDays(4), postazione3, utente3);
            prenotazioneService.createPrenotazione(prenotazione3);

            Prenotazione prenotazione4 = new Prenotazione(LocalDate.now().plusDays(1), postazione2, utente4);
            prenotazioneService.createPrenotazione(prenotazione4);

            Prenotazione prenotazione5 = new Prenotazione(LocalDate.now().plusDays(1), postazione2, utente5);
            prenotazioneService.createPrenotazione(prenotazione5);

            Prenotazione prenotazione6 = new Prenotazione(LocalDate.now().plusDays(1), postazione2, utente1);
            prenotazioneService.createPrenotazione(prenotazione6);

            // Tentativo di prenotare nuovamente per lo stesso utente e postazione con riscontro del errore e insuccesso nella aggiunta al db:
            Prenotazione prenotazione7 = new Prenotazione(LocalDate.now().plusDays(1), postazione2, utente1);
            prenotazioneService.createPrenotazione(prenotazione7);
        } catch (Exception e) {
            System.out.println("Errore durante la creazione della prenotazione: " + e.getMessage() + "A nome del utente:" + utente1.getUsername());
        }
    }
    }

