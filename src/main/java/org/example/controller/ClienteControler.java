package org.example.controller;

import org.example.dtos.CrearClienteDTO;
import org.example.dtos.UpdateClienteDto;
import org.example.entity.Cliente;
import org.example.exceptions.PandoraErrorDto;
import org.example.service.imp.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    //TODO fix this
    @PostMapping
    public ResponseEntity<?> crearCliente(@Valid @RequestBody CrearClienteDTO clienteDto, BindingResult result) {
        if (result.hasErrors()) {

            PandoraErrorDto error = new PandoraErrorDto();
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            List<String> collect = result.getAllErrors()
                    .stream().map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.toList());
            error.setMessage(collect.toString());
            return ResponseEntity.badRequest().body(error);
        }
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
    public ResponseEntity<?> actualizacionDeDatos(@Valid @RequestBody UpdateClienteDto clienteDto,  BindingResult result){
        if (result.hasErrors()) {
            PandoraErrorDto error = new PandoraErrorDto();
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            List<String> collect = result.getAllErrors()
                    .stream().map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.toList());
            error.setMessage(collect.toString());
            return ResponseEntity.badRequest().body(error);
        }
        Cliente cliente = this.clienteService.actualizarCliente(clienteDto);
        return  ResponseEntity.ok(cliente);
    }
}
