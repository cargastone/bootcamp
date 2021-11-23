package com.proyecto1.clientes.Service;

import com.proyecto1.clientes.Dto.ClienteDto;
import com.proyecto1.clientes.Repository.ClienteRepository;
import com.proyecto1.clientes.Utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    //Creditos
    public Flux<ClienteDto> getClientes(){
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<ClienteDto> getCliente(String id){
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<ClienteDto> saveCliente(Mono<ClienteDto> clienteDtoMono){
        System.out.println("service method called ...");
        return  clienteDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<ClienteDto> updateCliente(Mono<ClienteDto> clienteDtoMono,String id){
        System.out.println("service method called ...");

        return repository.findById(id)
                .flatMap(p->clienteDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);

    }

    public Mono<Void> deleteCliente(String id){
        return repository.deleteById(id);
    }
}
