package com.manoelcampos.rest;

import com.manoelcampos.model.Cliente;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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

    /**
     * Seria ótimo se funcionasse, mas o método é ignorado e não é gerado um endpoint.
     * @param name
     * @return
     */
    @GET
    @Path("/name/{name}")
    default Cliente getByName(@PathParam("name") String name){
        return Cliente.findByName(name).orElseThrow(NotFoundException::new);
    }
}