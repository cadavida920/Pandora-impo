package org.example.dtos;
import lombok.Data;
import org.example.entity.Cliente;
import org.example.entity.Depositos;
import java.io.Serializable;

@Data
public class CrearDepositoDTO implements Serializable {

    private Double valorDeposito;
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
