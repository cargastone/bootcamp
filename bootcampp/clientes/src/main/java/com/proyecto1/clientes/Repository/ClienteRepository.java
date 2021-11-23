package com.proyecto1.clientes.Repository;

import com.proyecto1.clientes.Entidad.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente,String> {
}
