package com.proyecto1.movimientos.controller;

import com.proyecto1.movimientos.dto.MovimientosDto;
import com.proyecto1.movimientos.entity.Movimientos;
import com.proyecto1.movimientos.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

    @Autowired
    private MovimientosService service;

    @GetMapping(value = "/listar",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovimientosDto> getMovimientos(){
        return service.getMovimientos();
    }

    @GetMapping("/{id}")
    public Mono<MovimientosDto> getMovimiento(@PathVariable String id){
        return service.getMovimiento(id);
    }

    @PostMapping("/creditos/create")
    public Mono<ResponseEntity<Movimientos>> saveMovimientoCredito(@RequestBody MovimientosDto movimientosDtoMono){
        System.out.println("controller method called ...");
        return service.findIdCreditos(movimientosDtoMono.getIdProducto().getId()).flatMap(product->{
            movimientosDtoMono.setIdProducto(product);
            return service.saveMovimiento(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    @PutMapping("/creditos/update/")
    public Mono<ResponseEntity<Movimientos>> updateMovimientoCredito(@RequestBody MovimientosDto movimientosDtoMono){
        return service.findIdCreditos(movimientosDtoMono.getIdProducto().getId()).flatMap(client->{
            movimientosDtoMono.setIdProducto(client);
            return service.updateMovimiento(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @PostMapping("/cuentasBancarias/create")
    public Mono<ResponseEntity<Movimientos>> saveMovimientoCuentasBancarias(@RequestBody MovimientosDto movimientosDtoMono){
        System.out.println("controller method called ...");
        return service.findIdCuentaBancaria(movimientosDtoMono.getIdProducto().getId()).flatMap(product->{
            movimientosDtoMono.setIdProducto(product);
            return service.saveMovimiento(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    @PutMapping("/cuentasBancarias/update/")
    public Mono<ResponseEntity<Movimientos>> updateMovimientoCuentasBancarias(@RequestBody MovimientosDto movimientosDtoMono){
        return service.findIdCuentaBancaria(movimientosDtoMono.getIdProducto().getId()).flatMap(client->{
            movimientosDtoMono.setIdProducto(client);
            return service.updateMovimiento(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @PostMapping("/tarjetasCredito/create")
    public Mono<ResponseEntity<Movimientos>> saveMovimientoTarjetasCredito(@RequestBody MovimientosDto movimientosDtoMono){
        System.out.println("controller method called ...");
        return service.findIdTarjetasCreditos(movimientosDtoMono.getIdProducto().getId()).flatMap(product->{
            movimientosDtoMono.setIdProducto(product);
            return service.saveMovimiento(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    @PutMapping("/tarjetasCredito/update/")
    public Mono<ResponseEntity<Movimientos>> updateMovimientoTarjetasCredito(@RequestBody MovimientosDto movimientosDtoMono){
        return service.findIdTarjetasCreditos(movimientosDtoMono.getIdProducto().getId()).flatMap(client->{
            movimientosDtoMono.setIdProducto(client);
            return service.updateMovimiento(movimientosDtoMono)
                    .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteMovimiento(@PathVariable String id){
        return service.deleteMovimiento(id);
    }


}
