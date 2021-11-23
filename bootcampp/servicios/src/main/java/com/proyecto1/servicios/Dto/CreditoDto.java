package com.proyecto1.servicios.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditoDto {
    private String id;
    private String tipo;
    private double montoDesembolso;
    private Date fechaapertura;
    private ClienteDto cliente;
}
