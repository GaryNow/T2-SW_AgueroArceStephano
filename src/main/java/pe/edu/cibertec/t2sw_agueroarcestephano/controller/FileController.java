package pe.edu.cibertec.t2sw_agueroarcestephano.controller;

import lombok.AllArgsConstructor;
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

    @PostMapping
    public ResponseEntity<ArchivoDto> subirArchivo(@RequestParam("files") List<MultipartFile> multipartFileList) throws Exception{
        fileService.guardarArchivos(multipartFileList);
        return new ResponseEntity<>(ArchivoDto.builder().mensaje("Archivo subido correctamente").build(), HttpStatus.OK);
    }

}
