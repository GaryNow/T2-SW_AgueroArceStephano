package pe.edu.cibertec.t2sw_agueroarcestephano.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import pe.edu.cibertec.t2sw_agueroarcestephano.model.bd.Autor;

import java.util.Date;

@Data
public class PublicacionDTO {
    private Integer idPublicacion;

    private String titulo;

    private String resumen;

    private Date fechPublicacion;

}
