package com.proyecto1.movimientos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientosDto {
    private String id;
    private ProductoDto idProducto;
    private double monto;
    private LocalDate fechaRegistro;
    private int tipoMov; //tipo:1(salida) tipo:2(entrada)
    private int movCuantity; //Contador de movimientos
}
