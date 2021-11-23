package com.proyecto1.servicios.Repository;

import com.proyecto1.servicios.Dto.TarjetaCreditoDto;
import com.proyecto1.servicios.Entidad.TarjetaCredito;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TarjetaCreditoRepository extends ReactiveMongoRepository<TarjetaCredito,String> {


}
