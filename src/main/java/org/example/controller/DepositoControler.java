package org.example.controller;

import org.example.dtos.CrearDepositoDTO;
import org.example.dtos.DepositosDTO;
import org.example.entity.Depositos;
import org.example.exceptions.PandoraErrorDto;
import org.example.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deposito")
public class DepositoControler {
    @Autowired
    private DepositoService depositoService;

    //TODO fix this
    @PostMapping
    public ResponseEntity<?> guardarDeposito(@Valid @RequestBody CrearDepositoDTO depositoDTO, BindingResult result) {
        if (result.hasErrors()) {
            PandoraErrorDto error = new PandoraErrorDto();
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            List<String> collect = result.getAllErrors()
                    .stream().map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.toList());
            error.setMessage(collect.toString());
            return ResponseEntity.badRequest().body(error);
        }
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



    //TODO fix this
    @PutMapping
    public ResponseEntity<?> actualizarDeposito(@Valid @RequestBody  CrearDepositoDTO depositoDTO, BindingResult result){
        if (result.hasErrors()) {
            PandoraErrorDto error = new PandoraErrorDto();
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            List<String> collect = result.getAllErrors()
                    .stream().map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.toList());
            error.setMessage(collect.toString());
            return ResponseEntity.badRequest().body(error);
        }
        Depositos depositos = depositoDTO.transformar();
        Depositos depositos1 = depositoService.nuevoDeposito(depositos);
        return ResponseEntity.ok(depositos1);
    }

    @GetMapping(value = "/cliente/{id}")
    public  ResponseEntity<?> consultarDepositoPorCliente(@PathVariable Long id) {
        List<Depositos> depositos = depositoService.consultarDepositoPorCliente(id);
        List<DepositosDTO> depositosDTOS = depositos.stream()
                .map(deposito -> DepositosDTO.tranformar(deposito))
                .collect(Collectors.toList());
        return ResponseEntity.ok(depositosDTOS);
    }
}
