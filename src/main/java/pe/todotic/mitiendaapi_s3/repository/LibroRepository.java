package pe.todotic.mitiendaapi_s3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.todotic.mitiendaapi_s3.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
