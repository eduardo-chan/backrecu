package utez.edu.mx.recupera.controllers.producto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.recupera.models.producto.Producto;
import utez.edu.mx.recupera.models.producto.ProductoRepository;
import utez.edu.mx.recupera.services.producto.ProductoService;
import utez.edu.mx.recupera.utils.CustomResponse;

import java.util.List;

@RestController
@RequestMapping("/tienda/producto")
@CrossOrigin(origins ={"*"})
public class productoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Producto>>> getAll(){
        return new ResponseEntity<>(
                this.productoService.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Producto>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                this.productoService.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto productoCreado = productoRepository.save(producto);
        return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
    }

}
