package utez.edu.mx.recupera.models.fabricante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import utez.edu.mx.recupera.models.producto.Producto;

import java.util.List;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

    //List<Producto> findByFabricante(Fabricante fabricante);

    boolean existsByName(String name);


    @Query(
            value = "SELECT producto.* FROM producto JOIN fabricante ON producto.id_fabricante = fabricante.id WHERE fabricante.name = 'Asus'  OR fabricante.name = 'Hewlett-Packard' OR fabricante.name = 'Seagate'", nativeQuery = true
    )
    List<Producto> findFabricanteByNames();


    @Query(
            value = "SELECT * FROM fabricante WHERE id >= 4", nativeQuery = true
    )
    List<Fabricante> findFabricanteById();


    @Query(
            value = " SELECT fabricante.name, COUNT(*) AS cantidad_ productos FROM fabricante LEFT JOIN producto ON fabricante.id = producto.id GROUP BY fabricante.name;", nativeQuery = true

    )
    List<Fabricante> findAllFabricantesAndProductos();

    @Query(
            value = "SELECT f.name, COUNT(p.id) AS num_producto\n" +
                    "FROM fabricante f\n" +
                    "LEFT JOIN producto p ON f.id = p.id AND p.price>= 220\n" +
                    "GROUP BY f.id;", nativeQuery = true
    )
    List<Object[]> findFabricantesAndProductosPrecio();

    @Query(
            value = "SELECT p.name, p.price FROM producto p INNER JOIN (SELECT fabricante_id, AVG(price) AS precio_medio FROM producto GROUP BY fabricante_id) pm ON p.fabricante_id = pm.fabricante_id WHERE p.price >= pm.precio_medio", nativeQuery = true
    )
    List<Object[]> findPrecioPromedio();


}
