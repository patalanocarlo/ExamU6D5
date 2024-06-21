package CarloPatalano.ExamU6D5.Repository;

import CarloPatalano.ExamU6D5.Entities.Postazione;
import CarloPatalano.ExamU6D5.Entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostazioneRepository extends JpaRepository <Postazione,Long> {
    @Query("SELECT p FROM Postazione p " +
            "WHERE p.tipoPostazione = :tipoPostazione " +
            "AND p.edificio.citta = :citta") //:citta e tipopostazione li vado a decidere solo io nel mio runner
    List<Postazione> findByTipoPostazioneAndCitta(@Param("tipoPostazione") TipoPostazione tipoPostazione,
                                                  @Param("citta") String citta);
}
