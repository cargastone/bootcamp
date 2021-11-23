package com.proyecto1.servicios.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaCreditoDto {
    private String id;
    private double limiteCredito;
    private Date fechaapertura;
    private ClienteDto cliente;
    private Date fechaPago;
    private String firmante;//dni de cliente adicional

}
