package com.manoelcampos.rest;

import com.manoelcampos.model.Cliente;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;

/**
 * Usa a biblioteca quarkus-hibernate-orm-rest-data-panache para criar um
 * REST Resource automaticamente.
 */
public interface ClienteResource extends PanacheEntityResource<Cliente, Long> {
    /**
     * Não expõe a operação delete, impedindo que clientes sejam removidos pela API web.
     * @param id
     * @return
     */
    @MethodProperties(exposed = false)
    boolean delete(long id);
}