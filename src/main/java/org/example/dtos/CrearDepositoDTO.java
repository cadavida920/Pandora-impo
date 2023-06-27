package org.example.dtos;
import lombok.Data;
import org.example.entity.Cliente;
import org.example.entity.Depositos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class  CrearDepositoDTO implements Serializable {


    @NotNull(message = "El campo 'valor deposito' no puede estar vacío")
    private Double valorDeposito;

    @NotNull(message = "EL campo de 'id' no puede estar vacio")
    private Long clienteId;

    public Depositos transformar() {
        Depositos depositos = new Depositos();
        depositos.setValorDeposito(valorDeposito);
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        depositos.setCliente(cliente);
        return depositos;
    }

}
