package com.proyecto1.movimientos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientosDto {
    private String id;
    private ProductoDto idProducto;
    private double monto;
    private Date fechaRegistro;
    private int tipoMov; //tipo:1(salida) tipo:2(entrada)
}
