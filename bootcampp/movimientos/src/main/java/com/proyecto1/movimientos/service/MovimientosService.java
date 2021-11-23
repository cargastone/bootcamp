package com.proyecto1.movimientos.service;

import com.proyecto1.movimientos.Repository.MovimientosRepository;
import com.proyecto1.movimientos.dto.MovimientosDto;
import com.proyecto1.movimientos.dto.ProductoDto;
import com.proyecto1.movimientos.entity.Movimientos;
import com.proyecto1.movimientos.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovimientosService {
    private final WebClient webClient;
    private final ReactiveCircuitBreaker reactiveCircuitBreaker;

    String uriCreditos = "http://localhost:9393/servicios/creditos/{id}";
    String uriTarjetasCredito = "http://localhost:9393/servicios/tarjetasCredito/{id}";
    String uriCuentaBancaria = "http://localhost:9393/servicios/cuentasBancarias/{id}";

    public MovimientosService(ReactiveResilience4JCircuitBreakerFactory circuitBreakerFactory) {
        this.webClient = WebClient.builder().baseUrl(this.uriCreditos).build();
        this.reactiveCircuitBreaker = circuitBreakerFactory.create("idProducto");
    }
    @Autowired
    private MovimientosRepository repository;


    // Conexion con servicio
    public Mono<ProductoDto> findIdCreditos(String id) {
        System.out.println("method findTypeCustomer ...");
        return reactiveCircuitBreaker.run(webClient.get().uri(this.uriCreditos,id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(ProductoDto.class),
                throwable -> {
                    return this.getDefaultCreditos();
                });
    }

    public Mono<ProductoDto> getDefaultCreditos() {
        System.out.println("method getDefaultTypeCustomer ...");
        Mono<ProductoDto> dtoMono = Mono.just(new ProductoDto("0"));
        return dtoMono;
    }

    public Mono<ProductoDto> findIdTarjetasCreditos(String id) {
        System.out.println("method findTypeCustomer ...");
        return reactiveCircuitBreaker.run(webClient.get().uri(this.uriTarjetasCredito,id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(ProductoDto.class),
                throwable -> {
                    return this.getDefaultCreditos();
                });
    }

    public Mono<ProductoDto> getDefaultTarjetasCreditos() {
        System.out.println("method getDefaultTypeCustomer ...");
        Mono<ProductoDto> dtoMono = Mono.just(new ProductoDto("0"));
        return dtoMono;
    }
    public Mono<ProductoDto> findIdCuentaBancaria(String id) {
        System.out.println("method findTypeCustomer ...");
        return reactiveCircuitBreaker.run(webClient.get().uri(this.uriCuentaBancaria,id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(ProductoDto.class),
                throwable -> {
                    return this.getDefaultCreditos();
                });
    }

    public Mono<ProductoDto> getDefaultCuentaBancaria() {
        System.out.println("method getDefaultTypeCustomer ...");
        Mono<ProductoDto> dtoMono = Mono.just(new ProductoDto("0"));
        return dtoMono;
    }

    // Conexion con servicio

    public Flux<MovimientosDto> getMovimientos(){
        System.out.println("service method called ...");
        long start = System.currentTimeMillis();
        Flux<MovimientosDto> movimientos =  repository.findAll().map(AppUtils::entityToDto);
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return movimientos;
    }

    public Mono<MovimientosDto> getMovimiento(String id){
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<Movimientos> saveMovimiento(MovimientosDto movimientosDtoMono){
        System.out.println("service method called ...");
        Movimientos movimientos = AppUtils.dtoToEntity(movimientosDtoMono);
        return  repository.save(movimientos);
    }

    public Mono<Movimientos> updateMovimiento(MovimientosDto movimientosDtoMono){
        System.out.println("service method called ...");
        Movimientos movimientos = AppUtils.dtoToEntity(movimientosDtoMono);

        return repository.findById(movimientos.getId()).flatMap(custDB -> {
            return repository.save(movimientos);
        });
    }

    public Mono<Void> deleteMovimiento(String id){
        System.out.println("service method called ...");
        return repository.deleteById(id);
    }

}
