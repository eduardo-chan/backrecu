package utez.edu.mx.recupera.models.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import utez.edu.mx.recupera.models.fabricante.Fabricante;

import java.util.List;

public interface ProductoRepository extends JpaRepository <Producto, Long> {
    Boolean findAllById(long id);

    Producto save(Producto producto);










}
