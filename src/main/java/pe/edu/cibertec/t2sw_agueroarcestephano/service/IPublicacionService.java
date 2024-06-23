package pe.edu.cibertec.t2sw_agueroarcestephano.service;

import pe.edu.cibertec.t2sw_agueroarcestephano.model.bd.Publicacion;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.dto.PublicacionDTO;

import java.util.List;
import java.util.Optional;

public interface IPublicacionService {
    List<PublicacionDTO> listarPublicacion();
    Optional<PublicacionDTO> obtenerPublicacionxId(Integer id);
    Publicacion guardarPublicacion(Publicacion publicacion);
    boolean eliminarPublicacion(Integer id);
}
