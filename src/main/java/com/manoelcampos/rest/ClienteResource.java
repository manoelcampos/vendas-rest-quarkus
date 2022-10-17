package com.manoelcampos.rest;

import com.manoelcampos.model.Cliente;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

/**
 * Usa a biblioteca quarkus-hibernate-orm-rest-data-panache para criar um
 * REST Resource automaticamente.
 */
public interface ClienteResource extends PanacheEntityResource<Cliente, Long> {

}