package org.example.controller;
import org.example.dtos.CrearProductoDTO;
import org.example.dtos.ProductoDTO;
import org.example.dtos.UpdateProductoDto;
import org.example.entity.Cliente;
import org.example.entity.Depositos;
import org.example.entity.Producto;
import org.example.service.imp.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/producto")
public class ProductoControler {

    @Autowired
    private ProductoServiceImpl productoService;
    @PostMapping
    public Producto nuevoProducto(@RequestBody CrearProductoDTO productoDTO) {
        Producto producto = productoDTO.transformar();
        Producto nuevoProducto = this.productoService.nuevoProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto).getBody();
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

    @PutMapping
    public ResponseEntity<?> actualizarProducto(@RequestBody UpdateProductoDto productoDto){
        Producto depositos = this.productoService.actualizarProducto(productoDto);
        return ResponseEntity.ok(depositos);

    }





}
