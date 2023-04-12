package org.example.controller;

import org.example.dtos.CrearClienteDTO;
import org.example.dtos.UpdateClienteDto;
import org.example.entity.Cliente;
import org.example.service.imp.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {
    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultaClientePorId(@PathVariable Long id) {
        Cliente cliente = this.clienteService.obtenerClientePorId(id);
        return ResponseEntity.ok(cliente);
    }
    @PostMapping
    public ResponseEntity<?> crearCliente(@RequestBody CrearClienteDTO clienteDto) {
        Cliente cliente = clienteDto.transformar();
        Cliente clienteCreado = this.clienteService.crearCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }
    @GetMapping
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping
    public ResponseEntity<?> actualizacionDeDatos(@RequestBody UpdateClienteDto clienteDto){
        Cliente cliente = this.clienteService.actualizarCliente(clienteDto);
        return  ResponseEntity.ok(cliente);
    }



}
