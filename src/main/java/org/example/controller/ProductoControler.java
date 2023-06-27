package org.example.controller;
import org.example.dtos.CrearProductoDTO;
import org.example.dtos.ProductoDTO;
import org.example.dtos.UpdateProductoDto;
import org.example.entity.Producto;
import org.example.exceptions.PandoraErrorDto;
import org.example.service.imp.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producto")
public class ProductoControler {

    @Autowired
    private ProductoServiceImpl productoService;

    //TODO fix this
    @PostMapping
    public ResponseEntity<?> nuevoProducto(@Valid @RequestBody CrearProductoDTO productoDTO, BindingResult result) {
        if (result.hasErrors()) {
            PandoraErrorDto error = new PandoraErrorDto();
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            List<String> collect = result.getAllErrors()
                    .stream().map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.toList());
            error.setMessage(collect.toString());
            return ResponseEntity.badRequest().body(error);
        }
        Producto producto = productoDTO.transformar();
        Producto nuevoProducto = this.productoService.nuevoProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultaProductos(@PathVariable Integer id) {
        Producto producto = this.productoService.consultarProducto(id.longValue());

        return ResponseEntity.ok(ProductoDTO.convertirADTO(producto));
    }

    @GetMapping
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultaProductosPorClienteId(@PathVariable Long id) {
        List<Producto> productos = productoService.consultarProductosPorClienteId(id);

        List<ProductoDTO> productosDTO = productos.stream()
                .map(producto -> ProductoDTO.convertirADTO(producto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(productosDTO);
    }

    @GetMapping
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> todosLosProductos (){
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        List<ProductoDTO> productosDTO = productos.stream()
                .map(producto -> ProductoDTO.convertirADTO(producto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(productosDTO);
    }

    //TODO fix this
    @PutMapping
    public ResponseEntity<?> actualizarProducto(@Valid @RequestBody UpdateProductoDto productoDto, BindingResult result){
        if (result.hasErrors()) {
            PandoraErrorDto error = new PandoraErrorDto();
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            List<String> collect = result.getAllErrors()
                    .stream().map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.toList());
            error.setMessage(collect.toString());
            return ResponseEntity.badRequest().body(error);
        }
        Producto producto = this.productoService.actualizarProducto(productoDto);
        return ResponseEntity.ok(ProductoDTO.convertirADTO(producto));
    }
}
