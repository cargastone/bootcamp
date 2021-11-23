package com.proyecto1.servicios.Repository;

import com.proyecto1.servicios.Entidad.Credito;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoRepository extends ReactiveMongoRepository<Credito,String> {

}
