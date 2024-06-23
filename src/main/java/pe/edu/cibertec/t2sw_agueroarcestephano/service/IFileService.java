package pe.edu.cibertec.t2sw_agueroarcestephano.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {

    void guardarArchivo(MultipartFile archivo) throws Exception;
    void guardarArchivos(List<MultipartFile> archivosList) throws Exception;
}
