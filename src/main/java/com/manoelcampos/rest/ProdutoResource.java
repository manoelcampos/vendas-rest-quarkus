package com.manoelcampos.rest;

import com.manoelcampos.model.Produto;
import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Cria um REST Resource da forma convencional, implementando manualmente cada método exposto (endpoint).
 * @see ClienteResource
 */
@Consumes(MediaType.APPLICATION_JSON)
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
    public void insert(final Produto produto) {
        Produto.persist(produto);
    }

    /** Como estamos implementando o {@link ProdutoResource} do zero,
     * para que o Lock Otimista funcione (ver class {@link Produto}),
     * é preciso chamar o método merge a partir do EntityManager,
     * por conta do bug https://github.com/quarkusio/quarkus/issues/7193.
     *
     * <p>Se o resource usar a lib REST Data Panache
     * (criando uma interface que estende {@link io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource}),
     * o método update já funciona com o Lock, sem precisar criar uma implementação
     * personalizada do método update.</p>
     */
    @PUT()
    @Path("/{id}")
    @Transactional
    public void update(final Produto produto) {
        final var em = JpaOperations.INSTANCE.getEntityManager();
        em.merge(produto);
    }

}