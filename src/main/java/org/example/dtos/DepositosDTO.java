package org.example.dtos;

import lombok.Data;
import org.example.entity.Depositos;

@Data
public class DepositosDTO {

    private Long id;

    private Double valorDeposito;

    private ClienteDTO cliente;

    public static DepositosDTO tranformar(Depositos depositos) {
        DepositosDTO depositosDTO = new DepositosDTO();
        depositosDTO.setId(depositos.getId());
        depositosDTO.setValorDeposito(depositos.getValorDeposito());
        depositosDTO.setCliente(ClienteDTO.transformar(depositos.getCliente()));
        return depositosDTO;
    }

}
