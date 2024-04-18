package co.edu.uceva.servicioasignatura.model.dao;

import co.edu.uceva.servicioasignatura.model.entities.Asignatura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IAsignaturaDao extends CrudRepository<Asignatura, Long> {
    @Query("SELECT a FROM Asignatura a WHERE a.ova_id = ?1")
    Asignatura findByOvaId(String ovaId);
}
