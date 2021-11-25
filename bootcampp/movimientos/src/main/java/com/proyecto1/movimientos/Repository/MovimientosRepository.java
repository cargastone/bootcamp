package com.proyecto1.movimientos.Repository;

import com.proyecto1.movimientos.entity.Movimientos;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovimientosRepository extends ReactiveMongoRepository<Movimientos,String> {

    public Flux<Movimientos> FindByIdProducto(String idProduct);
}
