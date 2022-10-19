package com.manoelcampos.rest;

import com.manoelcampos.model.Categoria;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Cria um REST Resource da forma convencional, implementando manualmente cada método exposto (endpoint).
 * @see ClienteResource
 */
@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @GET
    public List<Categoria> list() {
        return Categoria.listAll();
    }

    @GET()
    @Path("/{id}")
    public Categoria findById(@PathParam("id") final long id) {
        return Categoria.findById(id);
    }

    @POST()
    @Transactional
    public void insert(final Categoria categoria) {
        Categoria.persist(categoria);
    }
}