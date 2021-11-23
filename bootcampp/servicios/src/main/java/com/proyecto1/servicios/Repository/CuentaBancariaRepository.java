package com.proyecto1.servicios.Repository;

import com.proyecto1.servicios.Entidad.CuentaBancaria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaBancariaRepository extends ReactiveMongoRepository<CuentaBancaria,String> {
}
