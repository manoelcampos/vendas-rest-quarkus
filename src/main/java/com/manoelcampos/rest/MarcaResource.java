package com.manoelcampos.rest;

import com.manoelcampos.model.Marca;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Uma implementação diferente de uma classe resource (REST controller)
 * a partir de uma interface que já fornece métodos básicos implementados
 * e permite criar outros métodos adicionais.
 */
@Path("/marca")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MarcaResource implements AbstractResource<Marca> {
    @GET
    @Path("/nome/{nome}")
    public Marca findByName(final String nome) {
        return Marca.findByName(nome).orElseThrow(NotFoundException::new);
    }
}
