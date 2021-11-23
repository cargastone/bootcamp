package com.proyecto1.clientes.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    private String nroDoc;
    private String tipoDoc;
    private String nombres;
    private String apellidos;
    private Integer celular;
    private String razonSocial;
}
