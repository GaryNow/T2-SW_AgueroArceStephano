package pe.edu.cibertec.t2sw_agueroarcestephano.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;

    @Column(nullable = false)
    private String nomAutor;

    @Column(nullable = false)
    private String apeAutor;

    @Column(nullable = false)
    private Date fechNacAutor;
}
