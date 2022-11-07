package com.manoelcampos.rest;

import com.manoelcampos.model.Categoria;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Cria um REST Resource da forma convencional, implementando manualmente cada método exposto (endpoint).
 * @see ClienteResource
 */
@Path("/categoria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Operation(summary = "Obtém a lista de categorias cadastradas")
    @APIResponse(
        responseCode = "200",
        description = "Lista obtida com sucesso"
    )
    @GET
    public List<Categoria> list() {
        return Categoria.listAll();
    }

    @Operation(summary = "Obtém uma categoria pelo seu número identificador")
    @APIResponses(
        {@APIResponse(
                responseCode = "200",
                description = "Categoria obtida com sucesso"
        ),
        @APIResponse(
            responseCode = "404",
            description = "Categoria não encontrada"
        )}
    )
    @GET()
    @Path("/{id}")
    public Categoria findById(
        @Parameter(description = "Id da categoria a ser localizada", required = true)
        @PathParam("id") final long id)
    {
        return Categoria.findById(id);
    }

    @Operation(summary = "Insere uma categoria")
    @APIResponse(
        responseCode = "201",
        description = "Categoria inserida com sucesso"
    )

    @POST()
    @Transactional
    public void insert(
        @RequestBody(description = "Categoria a ser inserida", required = true)
        final Categoria categoria)
    {
        Categoria.persist(categoria);
    }
}