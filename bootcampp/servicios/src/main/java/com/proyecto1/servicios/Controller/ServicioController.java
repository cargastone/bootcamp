package com.proyecto1.servicios.Controller;

import com.proyecto1.servicios.Dto.CreditoDto;
import com.proyecto1.servicios.Dto.CuentaBancariaDto;
import com.proyecto1.servicios.Dto.TarjetaCreditoDto;
import com.proyecto1.servicios.Entidad.Credito;
import com.proyecto1.servicios.Entidad.CuentaBancaria;
import com.proyecto1.servicios.Entidad.TarjetaCredito;
import com.proyecto1.servicios.Service.ServiciosService;
import com.proyecto1.servicios.Utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private ServiciosService service;

        @GetMapping(value = "/tarjetasCredito/listar",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TarjetaCreditoDto> getTarjetaCreditos(){
        return service.getTarjetaCreditos();
    }

    @GetMapping("/tarjetasCredito/{id}")
    public Mono<TarjetaCreditoDto> getTarjetaCredito(@PathVariable String id){
        return service.getTarjetaCredito(id);
    }

    @PostMapping("/tarjetasCredito/create")
    public Mono<ResponseEntity<TarjetaCredito>> saveTarjetaCredito(@RequestBody TarjetaCreditoDto productDtoMono){
        System.out.println("controller method called ...");
        return service.findTypeCustomer(productDtoMono.getCliente().getId()).flatMap(client->{
            productDtoMono.setCliente(client);
            return service.saveTarjetaCredito(productDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping("/tarjetasCredito/update/")
    public Mono<ResponseEntity<TarjetaCredito>> updateTarjetaCredito(@RequestBody TarjetaCreditoDto productDtoMono){
        return service.findTypeCustomer(productDtoMono.getCliente().getId()).flatMap(client->{
            productDtoMono.setCliente(client);
            return service.updateTarjetaCredito(productDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/tarjetasCredito/delete/{id}")
    public Mono<Void> deleteTarjetaCredito(@PathVariable String id){
        return service.deleteTarjetaCredito(id);
    }



    //Creditos

    @GetMapping("/creditos/listar")
    public Flux<CreditoDto> getCreditos(){
        return service.getCreditos();
    }

    @GetMapping("/creditos/{id}")
    public Mono<CreditoDto> getCredito(@PathVariable String id){
        return service.getCredito(id);
    }

    @PostMapping("/creditos/create")
    public Mono<ResponseEntity<Credito>> saveCredito(@RequestBody CreditoDto productDtoMono){
        System.out.println("controller method called ...");
        return service.findTypeCustomer(productDtoMono.getCliente().getId()).flatMap(client->{
            productDtoMono.setCliente(client);
            return service.saveCredito(productDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        //return service.saveCredito(productDtoMono);
    }



    @PutMapping("/creditos/update/")
    public Mono<ResponseEntity<Credito>> updateCredito(@RequestBody CreditoDto productDtoMono){
        System.out.println("controller method called ...");
        return service.findTypeCustomer(productDtoMono.getCliente().getId()).flatMap(client->{
            productDtoMono.setCliente(client);
            return service.updateCredito(productDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        //return service.updateCredito(productDtoMono,id);
    }


    @DeleteMapping("/creditos/delete/{id}")
    public Mono<Void> deleteCredito(@PathVariable String id){
        return service.deleteCredito(id);
    }


    //Cuentas bancarias

    @GetMapping("/cuentasBancarias/listar")
    public Flux<CuentaBancariaDto> getCuentasBancarias(){
        return service.getCuentasBancarias();
    }

    @GetMapping("/cuentasBancarias/{id}")
    public Mono<CuentaBancariaDto> getCuentasBancaria(@PathVariable String id){
        return service.getCuentasBancaria(id);
    }

    @PostMapping("/cuentasBancarias/create")
    public Mono<ResponseEntity<CuentaBancaria>> saveCuentasBancaria(@RequestBody CuentaBancariaDto productDtoMono){
        System.out.println("controller method called ...");
        return service.findTypeCustomer(productDtoMono.getCliente().getId()).flatMap(client->{
            productDtoMono.setCliente(client);
            return service.saveCuentasBancaria(productDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        //return service.saveCredito(productDtoMono);
    }



    @PutMapping("/cuentasBancarias/update/")
    public Mono<ResponseEntity<CuentaBancaria>> updateCuentasBancaria(@RequestBody CuentaBancariaDto productDtoMono){
        System.out.println("controller method called ...");
        return service.findTypeCustomer(productDtoMono.getCliente().getId()).flatMap(client->{
            productDtoMono.setCliente(client);
            return service.updateCuentasBancaria(productDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        //return service.updateCredito(productDtoMono,id);
    }


    @DeleteMapping("/cuentasBancarias/delete/{id}")
    public Mono<Void> deleteCuentasBancaria(@PathVariable String id){
        return service.deleteCuentasBancaria(id);
    }


}
