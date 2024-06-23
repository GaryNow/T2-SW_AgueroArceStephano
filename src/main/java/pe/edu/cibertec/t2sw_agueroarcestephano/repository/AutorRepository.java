package pe.edu.cibertec.t2sw_agueroarcestephano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.bd.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
