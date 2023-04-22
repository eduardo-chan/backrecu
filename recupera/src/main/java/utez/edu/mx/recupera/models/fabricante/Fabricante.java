package utez.edu.mx.recupera.models.fabricante;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.recupera.models.producto.Producto;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fabricante")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 150)
    private String name;


    @OneToMany(mappedBy = "fabricante")
@JsonIgnore
    private List<Producto> producto;


}
