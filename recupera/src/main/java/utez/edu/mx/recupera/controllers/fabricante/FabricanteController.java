package utez.edu.mx.recupera.controllers.fabricante;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.recupera.models.fabricante.Fabricante;
import utez.edu.mx.recupera.models.fabricante.FabricanteRepository;
import utez.edu.mx.recupera.models.producto.Producto;
import utez.edu.mx.recupera.models.producto.ProductoRepository;
import utez.edu.mx.recupera.services.fabricante.FabricanteService;
import utez.edu.mx.recupera.services.producto.ProductoService;
import utez.edu.mx.recupera.utils.CustomResponse;

import java.util.List;

@RestController
@RequestMapping("/tienda/fabricante")
@CrossOrigin(origins ={"*"})
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;


    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Fabricante>>> getAll(){
        return new ResponseEntity<>(
                this.fabricanteService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Fabricante>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                this.fabricanteService.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Fabricante> crearFabricante(@RequestBody Fabricante fabricante) {
        Fabricante fabricanteCreado = fabricanteService.crearFabricante(fabricante);
        return new ResponseEntity<>(fabricanteCreado, HttpStatus.CREATED);
    }

    @GetMapping("/consulta1/")
    public ResponseEntity<CustomResponse<List<Fabricante>>> getFabricanteById(){
        return new ResponseEntity<>(
                this.fabricanteService.getFabricanteById(),
                HttpStatus.OK
        );
    }

    @GetMapping("/consulta2/")
    public ResponseEntity<CustomResponse<List<Fabricante>>> getFabricanteByName2(){
        return new ResponseEntity<>(
                this.fabricanteService.getFabricantesAndProductos(),
                HttpStatus.OK
        );
    }


    @GetMapping("/consulta3/")
    public ResponseEntity<CustomResponse<List<Object[]>>> getFabricantesAndProductos3(){
        return new ResponseEntity<>(
                this.fabricanteService.getFabricantesAndProductoss(),
                HttpStatus.OK
        );
    }

    @GetMapping("/consulta4/")
    public ResponseEntity<CustomResponse<List<Object[]>>> gewtPrecioPromm(){
        return new ResponseEntity<>(
                this.fabricanteService.getPrecioProm(),
                HttpStatus.OK
        );
    }

    @GetMapping("/consulta11/")
    public ResponseEntity<CustomResponse<List<Producto>>> getproo(){
        return new ResponseEntity<>(
                this.fabricanteService.getpro(),
                HttpStatus.OK
        );
    }







}
