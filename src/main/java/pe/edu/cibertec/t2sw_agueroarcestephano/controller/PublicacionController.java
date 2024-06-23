package pe.edu.cibertec.t2sw_agueroarcestephano.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.bd.Autor;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.bd.Publicacion;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.dto.PublicacionDTO;
import pe.edu.cibertec.t2sw_agueroarcestephano.service.IAutorService;
import pe.edu.cibertec.t2sw_agueroarcestephano.service.IPublicacionService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/publicacion")
public class PublicacionController {
    private IPublicacionService publicacionService;

    private IAutorService autorService;

    @GetMapping
    public ResponseEntity<List<PublicacionDTO>> listarPublicaciones(){
        List<PublicacionDTO> publicacionList = publicacionService.listarPublicacion();
        if(publicacionList.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(publicacionList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDTO> obtenerPublicacionXId(@PathVariable Integer id){
        PublicacionDTO publicacion = publicacionService.obtenerPublicacionxId(id).get();
        if(publicacion == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(publicacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Publicacion> registrarPublicacion(@Validated @RequestBody Publicacion publicacion) {
        Publicacion savedPublicacion = publicacionService.guardarPublicacion(publicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPublicacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Integer id, @RequestBody Publicacion publicacion){

        Publicacion newPublicacion = publicacionService.guardarPublicacion(publicacion);

        return new ResponseEntity<>(newPublicacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarPublicacion(Integer id){
        if(publicacionService.eliminarPublicacion(id))
            return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}
