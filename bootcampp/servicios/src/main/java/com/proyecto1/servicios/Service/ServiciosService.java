package com.proyecto1.servicios.Service;

import com.proyecto1.servicios.Dto.ClienteDto;
import com.proyecto1.servicios.Dto.CreditoDto;
import com.proyecto1.servicios.Dto.CuentaBancariaDto;
import com.proyecto1.servicios.Dto.TarjetaCreditoDto;
import com.proyecto1.servicios.Entidad.Credito;
import com.proyecto1.servicios.Entidad.CuentaBancaria;
import com.proyecto1.servicios.Entidad.TarjetaCredito;
import com.proyecto1.servicios.Repository.CreditoRepository;
import com.proyecto1.servicios.Repository.CuentaBancariaRepository;
import com.proyecto1.servicios.Repository.TarjetaCreditoRepository;
import com.proyecto1.servicios.Utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ServiciosService {

    private final WebClient webClient;
    private final ReactiveCircuitBreaker reactiveCircuitBreaker;

    String uri = "http://localhost:9292/clientes/{id}";

    public ServiciosService(ReactiveResilience4JCircuitBreakerFactory circuitBreakerFactory) {
        this.webClient = WebClient.builder().baseUrl(this.uri).build();
        this.reactiveCircuitBreaker = circuitBreakerFactory.create("cliente");
    }
    @Autowired
    private TarjetaCreditoRepository repositoryTarjetaCredito;
    @Autowired
    private CreditoRepository repositoryCredito;
    @Autowired
    private CuentaBancariaRepository repositoryCuentaBancaria;

    // Conexion con servicio
    public Mono<ClienteDto> findTypeCustomer(String id) {
        System.out.println("method findTypeCustomer ...");
        return reactiveCircuitBreaker.run(webClient.get().uri(this.uri,id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(ClienteDto.class),
                throwable -> {
                    return this.getDefaultTypeCustomer();
                });
    }

    public Mono<ClienteDto> getDefaultTypeCustomer() {
        System.out.println("method getDefaultTypeCustomer ...");
        Mono<ClienteDto> cliente = Mono.just(new ClienteDto("0"));
        return cliente;
    }
    // Conexion con servicio

    public Flux<TarjetaCreditoDto> getTarjetaCreditos(){
        long start = System.currentTimeMillis();
         Flux<TarjetaCreditoDto> tarjetasCreditos =  repositoryTarjetaCredito.findAll().map(AppUtils::entityToDto);
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return tarjetasCreditos;
    }

    public Mono<TarjetaCreditoDto> getTarjetaCredito(String id){
        return repositoryTarjetaCredito.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<TarjetaCredito> saveTarjetaCredito(TarjetaCreditoDto creditoDtoMono){
        System.out.println("method saveTarjetaCredito ...");
        TarjetaCredito tarjetaCredito = AppUtils.dtoToEntity(creditoDtoMono);
        return  repositoryTarjetaCredito.save(tarjetaCredito);
    }

    public Mono<TarjetaCredito> updateTarjetaCredito(TarjetaCreditoDto creditoDtoMono){
        System.out.println("method updateTarjetaCredito ...");
        TarjetaCredito tarjetaCredito = AppUtils.dtoToEntity(creditoDtoMono);

        return repositoryTarjetaCredito.findById(tarjetaCredito.getId()).flatMap(custDB -> {
            return repositoryTarjetaCredito.save(tarjetaCredito);
        });

    }

    public Mono<Void> deleteTarjetaCredito(String id){
        return repositoryTarjetaCredito.deleteById(id);
    }


    //Creditos
    public Flux<CreditoDto> getCreditos(){
        return repositoryCredito.findAll().map(AppUtils::entityToDto);
    }

    public Mono<CreditoDto> getCredito(String id){
        return repositoryCredito.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<Credito> saveCredito(CreditoDto creditoDtoMono){
        System.out.println("service method called ...");
        Credito credito = AppUtils.dtoToEntity(creditoDtoMono);

        return  repositoryCredito.save(credito);

    }

    public Mono<Credito> updateCredito(CreditoDto creditoDtoMono){

        System.out.println("method updateCredito ...");
        Credito credito = AppUtils.dtoToEntity(creditoDtoMono);

        return repositoryCredito.findById(credito.getId()).flatMap(custDB -> {
            return repositoryCredito.save(credito);
        });

    }

    public Mono<Void> deleteCredito(String id){
        return repositoryCredito.deleteById(id);
    }

    //CuentaBancaria
    public Flux<CuentaBancariaDto> getCuentasBancarias(){
        return repositoryCuentaBancaria.findAll().map(AppUtils::entityToDto);
    }

    public Mono<CuentaBancariaDto> getCuentasBancaria(String id){
        return repositoryCuentaBancaria.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<CuentaBancaria> saveCuentasBancaria(CuentaBancariaDto cuentaBancariaDtoMono){
        System.out.println("service method called ...");
        CuentaBancaria cuentaBancaria = AppUtils.dtoToEntity(cuentaBancariaDtoMono);

        return  repositoryCuentaBancaria.save(cuentaBancaria);
    }

    public Mono<CuentaBancaria> updateCuentasBancaria(CuentaBancariaDto cuentaBancariaDtoMono){
        System.out.println("method updateCredito ...");
        CuentaBancaria cuentaBancaria = AppUtils.dtoToEntity(cuentaBancariaDtoMono);

        return repositoryCuentaBancaria.findById(cuentaBancaria.getId()).flatMap(custDB -> {
            return repositoryCuentaBancaria.save(cuentaBancaria);
        });
    }



    public Mono<Void> deleteCuentasBancaria(String id){
        return repositoryCuentaBancaria.deleteById(id);
    }



}
