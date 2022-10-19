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
@Produces(MediaType.APPLICATION_JSON)
@Path("/produto")
public class ProdutoResource {
    @GET
    public List<Produto> list() {
        return Produto.listAll();
    }

    @GET()
    @Path("/{id}")
    public Produto findById(@PathParam("id") final long id) {
        return Produto.findById(id);
    }

    @POST()
    @Transactional
    public void insert(final Produto Produto) {
        Produto.persistAndFlush();
    }
}