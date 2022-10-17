package com.manoelcampos.rest;

import com.manoelcampos.model.Produto;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Cria um REST Resource da forma convencional, implementando manualmente cada método exposto (endpoint).
 * @see ClienteResource
 */
@Path("/produto")
public class ProdutoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> list() {
        return Produto.listAll();
    }

    @GET()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto findById(@PathParam("id") final long id) {
        return Produto.findById(id);
    }

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void insert(final Produto Produto) {
        Produto.persistAndFlush();
    }
}