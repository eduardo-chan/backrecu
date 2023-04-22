package utez.edu.mx.recupera.services.fabricante;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.recupera.models.fabricante.Fabricante;
import utez.edu.mx.recupera.models.fabricante.FabricanteRepository;
import utez.edu.mx.recupera.models.producto.Producto;
import utez.edu.mx.recupera.models.producto.ProductoRepository;
import utez.edu.mx.recupera.utils.CustomResponse;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class FabricanteService {
    @Autowired
    private FabricanteRepository fabricanteRepository;



    public Fabricante crearFabricante(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }


    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<List<Fabricante>> getAll() {
        return new CustomResponse<>(
                this.fabricanteRepository.findAll(),
                false,
                200,
                "ok"
        );

    }

    @Transactional(readOnly = true)
    public CustomResponse<Fabricante>getOne(Long id){
        return new CustomResponse<>(
                this.fabricanteRepository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }










    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<List<Fabricante>> getFabricanteById() {
        return new CustomResponse<>(
                this.fabricanteRepository.findFabricanteById(),
                false,
                200,
                "ok"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<List<Fabricante>> getFabricantesAndProductos() {
        return new CustomResponse<>(
                this.fabricanteRepository.findAllFabricantesAndProductos(),
                false,
                200,
                "ok"
        );

    }


    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<List<Object[]>>  getFabricantesAndProductoss() {
        return new CustomResponse<>(
                this.fabricanteRepository.findFabricantesAndProductosPrecio(),
                false,
                200,
                "ok"
        );
    }


    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<List<Object[]>>getPrecioProm() {
        return new CustomResponse<>(
                this.fabricanteRepository.findPrecioPromedio(),
                false,
                200,
                "ok"
        );
    }




    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<List<Producto>> getpro() {
        return new CustomResponse<>(
                this.fabricanteRepository.findFabricanteByNames(),
                false,
                200,
                "ok"
        );

    }








}
