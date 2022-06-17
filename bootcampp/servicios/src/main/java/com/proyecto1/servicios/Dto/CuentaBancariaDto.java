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
    private double montoMinMes; //monto mínimo del mes
    private int limitMaxMov; // límite maximo de movimientos
    private int numMaxTrnsac; //Número maximo de transacciones
    private Date fechaApertura;
    private ClienteDto cliente;
}
