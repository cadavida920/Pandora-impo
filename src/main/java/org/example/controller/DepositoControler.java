package org.example.controller;

import org.example.dtos.CrearClienteDTO;
import org.example.dtos.CrearDepositoDTO;
import org.example.dtos.DepositosDTO;
import org.example.entity.Cliente;
import org.example.entity.Depositos;
import org.example.service.DepositoService;
import org.example.service.imp.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposito")
public class DepositoControler {
    @Autowired
    private DepositoService depositoService;

    @PostMapping
    public ResponseEntity<DepositosDTO> guardarDeposito(@RequestBody CrearDepositoDTO depositoDTO) {
        Depositos deposito = depositoDTO.transformar();
        Depositos depositos = depositoService.nuevoDeposito(deposito);
        DepositosDTO resultado = DepositosDTO.tranformar(depositos);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping
    public ResponseEntity<List<Depositos>> buscarTodosDepositos() {
        List<Depositos> depositos = depositoService.consultarTodosLosDepositos();
        return ResponseEntity.ok(depositos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Depositos> buscarDeposito(@PathVariable Long id) {
        Depositos depositos = depositoService.consultarDepositoPorId(id);
        return ResponseEntity.ok(depositos);
    }
    @PutMapping
    public ResponseEntity<?> actualizarDeposito(@RequestBody  CrearDepositoDTO depositoDTO){
        Depositos depositos = depositoDTO.transformar();
        Depositos depositos1 = depositoService.nuevoDeposito(depositos);
        return ResponseEntity.ok(depositos1);
    }

}
