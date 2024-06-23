package pe.edu.cibertec.t2sw_agueroarcestephano.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService {



    private final Path pathFolder = Paths.get("uploads");

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        validarTipoArchivo(archivo);
        Files.copy(archivo.getInputStream(), this.pathFolder.resolve(archivo.getOriginalFilename()));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivosList) throws Exception {
        for(MultipartFile archivo: archivosList){
            this.guardarArchivo(archivo);
        }
    }

    private void validarTipoArchivo(MultipartFile archivo) throws IOException {
        String contentType = archivo.getContentType();
        if (contentType == null || !esTipoValido(contentType)) {
            throw new IllegalArgumentException("El tipo de archivo no es válido: " + archivo.getOriginalFilename());
        }
    }

    private boolean esTipoValido(String contentType) {
        return contentType.equals("application/pdf") ||
                contentType.equals("image/png") ||
                contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    }
}
