package pe.edu.cibertec.t2sw_agueroarcestephano.model.bd;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutor")
    private Integer idAutor;

    @Column(name = "nomAutor", nullable = false)
    private String nomAutor;

    @Column(name = "apeAutor", nullable = false)
    private String apeAutor;

    @Column(name = "fechNacAutor", nullable = false)
    private Date fechNacAutor;
}
