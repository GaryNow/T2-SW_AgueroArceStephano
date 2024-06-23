package pe.edu.cibertec.t2sw_agueroarcestephano.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.bd.Publicacion;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.dto.PublicacionDTO;
import pe.edu.cibertec.t2sw_agueroarcestephano.repository.PublicacionRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublicacionService implements IPublicacionService{

    private PublicacionRepository publicacionRepository;
    @Override
    public List<PublicacionDTO> listarPublicacion(){
        var publicaciones = publicacionRepository.findAll();

        List<PublicacionDTO> publicacionDTOs = new ArrayList<>();
        for(Publicacion publicacion : publicaciones){
            PublicacionDTO publicacionDTO = new PublicacionDTO();
            publicacionDTO.setIdPublicacion(publicacion.getIdPublicacion());
            publicacionDTO.setTitulo(publicacion.getTitulo());
            publicacionDTO.setResumen(publicacion.getResumen());
            publicacionDTO.setFechPublicacion(publicacion.getFechPublicacion());
            publicacionDTOs.add(publicacionDTO);
        }

        return publicacionDTOs;

    }

    @Override
    public Optional<PublicacionDTO> obtenerPublicacionxId(Integer id) {
        Optional<Publicacion> publicacion = publicacionRepository.findById(id);
        if(publicacion.isEmpty()){
            return Optional.empty();
        }

        PublicacionDTO publicacionDTO = new PublicacionDTO();
        publicacionDTO.setIdPublicacion(publicacion.get().getIdPublicacion());
        publicacionDTO.setTitulo(publicacion.get().getTitulo());
        publicacionDTO.setResumen(publicacion.get().getResumen());
        publicacionDTO.setFechPublicacion(publicacion.get().getFechPublicacion());
        return Optional.of(publicacionDTO);

    }

    @Override
    public Publicacion guardarPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public boolean eliminarPublicacion(Integer id) {
        Optional<Publicacion> publicacion = publicacionRepository.findById(id);
        if(publicacion.isPresent()){
            publicacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
