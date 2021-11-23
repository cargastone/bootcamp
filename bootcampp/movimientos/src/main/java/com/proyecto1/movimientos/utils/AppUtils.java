package com.proyecto1.movimientos.utils;

import com.proyecto1.movimientos.dto.MovimientosDto;
import com.proyecto1.movimientos.entity.Movimientos;
import org.springframework.beans.BeanUtils;
import org.springframework.web.reactive.function.client.WebClient;

public class AppUtils {
    public static MovimientosDto entityToDto(Movimientos movimientos) {
        MovimientosDto movimientosDto = new MovimientosDto();
        BeanUtils.copyProperties(movimientos, movimientosDto);
        return movimientosDto;
    }

    public static Movimientos dtoToEntity(MovimientosDto movimientosDto) {
        Movimientos movimientos = new Movimientos();
        BeanUtils.copyProperties(movimientosDto, movimientos);
        return movimientos;
    }

}
