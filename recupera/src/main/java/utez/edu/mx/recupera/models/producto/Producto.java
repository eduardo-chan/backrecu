package utez.edu.mx.recupera.models.producto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.recupera.models.fabricante.Fabricante;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 150)
    private String name;

    @Column(unique = true, nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

}
