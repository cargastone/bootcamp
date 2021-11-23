package com.proyecto1.clientes.Utils;


import com.proyecto1.clientes.Dto.ClienteDto;
import com.proyecto1.clientes.Entidad.Cliente;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    //cuentas bancarias
    public static ClienteDto entityToDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }

    public static Cliente dtoToEntity(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDto, cliente);
        return cliente;
    }
}
