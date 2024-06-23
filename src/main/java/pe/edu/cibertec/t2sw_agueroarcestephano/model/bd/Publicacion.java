package pe.edu.cibertec.t2sw_agueroarcestephano.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacion;

    @Column(nullable = false, length = 250)
    private String titulo;

    @Column(nullable = false, length = 250)
    private String resumen;

    @Column(nullable = false)
    private Date fechPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAutor", nullable = false)
    private Autor autor;
}
