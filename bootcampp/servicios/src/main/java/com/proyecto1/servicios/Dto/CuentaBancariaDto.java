package com.proyecto1.servicios.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancariaDto {
    private String id;
    private String tipo;
    private double saldo;
    private double mantenimiento;
    private long estado;
    private Date fechaApertura;
    private ClienteDto cliente;
}
