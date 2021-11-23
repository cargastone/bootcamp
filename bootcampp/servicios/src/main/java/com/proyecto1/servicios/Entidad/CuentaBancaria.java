package com.proyecto1.servicios.Entidad;

import com.proyecto1.servicios.Dto.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cuentaBancaria")
public class CuentaBancaria {
    @Id
    private String id;
    private String tipo;
    private double saldo;
    private double mantenimiento;
    private long estado;
    private Date fechaApertura;
    private ClienteDto cliente;
}
