package pe.edu.cibertec.t2sw_agueroarcestephano.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.bd.Autor;
import pe.edu.cibertec.t2sw_agueroarcestephano.service.IAutorService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/autor")
public class AutorController {
    private IAutorService iAutorService;

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores(){
        List<Autor> autorList = new ArrayList<>(iAutorService.listarAutor());
        if(autorList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(autorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorXId(@PathVariable Integer id){
        Autor autor = iAutorService.obtenerAutorxId(id).get();
        if(autor == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Autor> registrarAutor(@RequestBody Autor autor){
        return new ResponseEntity<>(iAutorService.guardarAutor(autor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Integer id, @RequestBody Autor autor){
        Autor newAutor = iAutorService.obtenerAutorxId(id).get();
        if(newAutor == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        newAutor.setNomAutor(autor.getNomAutor());
        newAutor.setApeAutor(autor.getApeAutor());
        newAutor.setFechNacAutor(autor.getFechNacAutor());
        return new ResponseEntity<>(iAutorService.guardarAutor(newAutor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarAutor(@PathVariable Integer id){
        if(iAutorService.eliminarAutor(id))
            return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}
