package CarloPatalano.ExamU6D5.Repository;


import CarloPatalano.ExamU6D5.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository <Utente,Long> {
}
