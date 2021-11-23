package com.proyecto1.clientes.Controller;

import com.proyecto1.clientes.Dto.ClienteDto;
import com.proyecto1.clientes.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/listar",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ClienteDto> getTarjetaCreditos(){
        return service.getClientes();
    }

    @GetMapping("/{id}")
    public Mono<ClienteDto> getTarjetaCredito(@PathVariable String id){
        return service.getCliente(id);
    }

    @PostMapping("/create")
    public Mono<ClienteDto> saveTarjetaCredito(@RequestBody Mono<ClienteDto> clienteDtoMono){
        System.out.println("controller method called ...");
        return service.saveCliente(clienteDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<ClienteDto> updateTarjetaCredito(@RequestBody Mono<ClienteDto> clienteDtoMono,@PathVariable String id){
        return service.updateCliente(clienteDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteTarjetaCredito(@PathVariable String id){
        return service.deleteCliente(id);
    }
}
