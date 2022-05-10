package com.manoelcampos.rest;

import com.manoelcampos.model.Categoria;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categoria")
public class CategoriaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> list() {
        return Categoria.listAll();
    }

    @GET()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria findById(@PathParam("id") final long id) {
        return Categoria.findById(id);
    }

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void insert(final Categoria categoria) {
        categoria.persistAndFlush();
    }
}