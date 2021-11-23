package com.proyecto1.movimientos.Repository;

import com.proyecto1.movimientos.entity.Movimientos;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovimientosRepository extends ReactiveMongoRepository<Movimientos,String> {
}
