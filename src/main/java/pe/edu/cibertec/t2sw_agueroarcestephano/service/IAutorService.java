package pe.edu.cibertec.t2sw_agueroarcestephano.service;

import pe.edu.cibertec.t2sw_agueroarcestephano.model.bd.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    List<Autor> listarAutor();
    Optional<Autor> obtenerAutorxId(Integer id);
    Autor guardarAutor(Autor autor);
    boolean eliminarAutor(Integer id);
}
