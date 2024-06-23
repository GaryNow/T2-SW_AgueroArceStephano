package pe.edu.cibertec.t2sw_agueroarcestephano.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.bd.Autor;
import pe.edu.cibertec.t2sw_agueroarcestephano.repository.AutorRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AutorService implements IAutorService{

    private AutorRepository autorRepository;

    @Override
    public List<Autor> listarAutor() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> obtenerAutorxId(Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isEmpty()){
            return Optional.empty();
        }
        return autor;
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }


    @Override
    public boolean eliminarAutor(Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isPresent()){
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
