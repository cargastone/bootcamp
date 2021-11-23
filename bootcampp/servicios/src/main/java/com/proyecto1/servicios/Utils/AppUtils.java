package com.proyecto1.servicios.Utils;


import com.proyecto1.servicios.Dto.CreditoDto;
import com.proyecto1.servicios.Dto.CuentaBancariaDto;
import com.proyecto1.servicios.Dto.TarjetaCreditoDto;
import com.proyecto1.servicios.Entidad.Credito;
import com.proyecto1.servicios.Entidad.CuentaBancaria;
import com.proyecto1.servicios.Entidad.TarjetaCredito;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static TarjetaCreditoDto entityToDto(TarjetaCredito tarjetaCredito) {
        TarjetaCreditoDto tarjetaCreditoDto = new TarjetaCreditoDto();
        BeanUtils.copyProperties(tarjetaCredito, tarjetaCreditoDto);
        return tarjetaCreditoDto;
    }

    public static TarjetaCredito dtoToEntity(TarjetaCreditoDto tarjetaCreditoDto) {
        TarjetaCredito tarjetaCredito = new TarjetaCredito();
        BeanUtils.copyProperties(tarjetaCreditoDto, tarjetaCredito);
        return tarjetaCredito;
    }
    //creditos
    public static CreditoDto entityToDto(Credito credito) {
        CreditoDto creditoDto = new CreditoDto();
        BeanUtils.copyProperties(credito, creditoDto);
        return creditoDto;
    }

    public static Credito dtoToEntity(CreditoDto creditoDto) {
        Credito credito = new Credito();
        BeanUtils.copyProperties(creditoDto, credito);
        return credito;
    }
    //cuentas bancarias
    public static CuentaBancariaDto entityToDto(CuentaBancaria cuentaBancaria) {
        CuentaBancariaDto cuentaBancariaDto = new CuentaBancariaDto();
        BeanUtils.copyProperties(cuentaBancaria, cuentaBancariaDto);
        return cuentaBancariaDto;
    }

    public static CuentaBancaria dtoToEntity(CuentaBancariaDto cuentaBancariaDto) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        BeanUtils.copyProperties(cuentaBancariaDto, cuentaBancaria);
        return cuentaBancaria;
    }
}
