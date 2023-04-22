package utez.edu.mx.recupera.services.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.recupera.models.fabricante.Fabricante;
import utez.edu.mx.recupera.models.producto.Producto;
import utez.edu.mx.recupera.models.producto.ProductoRepository;
import utez.edu.mx.recupera.utils.CustomResponse;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
@Transactional

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;



    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<List<Producto>> getAll() {
        return new CustomResponse<>(
                this.productoRepository.findAll(),
                false,
                200,
                "ok"
        );

    }

        @Transactional(readOnly = true)
        public CustomResponse<Producto>getOne(Long id){
            return new CustomResponse<>(
                    this.productoRepository.findById(id).get(),
                    false,
                    200,
                    "Ok"
            );
        }





    }










