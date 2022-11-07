package com.manoelcampos.rest;

import com.manoelcampos.model.AbstractEntity;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Uma interface que fornece outra maneira de criar resources (REST controllers)
 * sem usar o {io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource}
 * (que é experimental para a versão do Quarkus em uso).
 * No entanto, sem usar a interface mencionada acima,
 * os métodos aqui não implementam recursos como paginação (que você deveria fazer manualmente).
 *
 * @param <T> Tipo de entidade que a classe Resource que implementará tal interface irá gerenciar
 */
public interface AbstractResource<T extends AbstractEntity> {
    @GET
    default List<T> list(){
        return AbstractEntity.listAll();
    }

    @GET()
    @Path("/{id}")
    default T findById(@PathParam("id") final long id) {
        return AbstractEntity.findById(id);
    }

    @POST()
    @Transactional
    default void insert(final T obj){
        AbstractEntity.persist(obj);
    }
}