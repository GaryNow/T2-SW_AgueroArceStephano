package pe.edu.cibertec.t2sw_agueroarcestephano.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.dto.ArchivoDto;
import pe.edu.cibertec.t2sw_agueroarcestephano.service.FileService;

import java.util.List;

@RestController
@RequestMapping("api/v1/files")
@AllArgsConstructor
public class FileController {

    private FileService fileService;

    private static final long MAX_FILE_SIZE = 25 * 1024 * 1024; // 25MB in bytes

    @PostMapping("/archivo")
    public ResponseEntity<ArchivoDto> subirArchivo(@RequestParam("file") MultipartFile file) {
        try {
            validarTamanioArchivo(file);
            fileService.guardarArchivo(file);
            return ResponseEntity.ok().body(ArchivoDto.builder().mensaje("Archivo subido correctamente").build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ArchivoDto.builder().mensaje(e.getMessage()).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ArchivoDto.builder().mensaje("Error al subir archivo: " + e.getMessage()).build());
        }
    }

    @PostMapping
    public ResponseEntity<ArchivoDto> subirArchivo(@RequestParam("files") List<MultipartFile> multipartFileList) throws Exception{
        fileService.guardarArchivos(multipartFileList);
        return new ResponseEntity<>(ArchivoDto.builder().mensaje("Archivo subido correctamente").build(), HttpStatus.OK);
    }

    private void validarTamanioArchivo(MultipartFile archivo) {
        if (archivo.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("El tamaño del archivo excede el límite permitido: " + archivo.getOriginalFilename());
        }
    }

}
