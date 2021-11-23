package com.proyecto1.movimientos.entity;

import com.proyecto1.movimientos.dto.ProductoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movimientos")
public class Movimientos {
    @Id
    private String id;
    private ProductoDto idProducto;
    private double monto;
    private Date fechaRegistro;
    private int tipoMov; //tipo:1(salida) tipo:2(entrada)
}
