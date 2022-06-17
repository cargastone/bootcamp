package com.proyecto1.movimientos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancariaDto {

    private String id;
    private int limitMaxMov; // límite maximo de movimientos

}
