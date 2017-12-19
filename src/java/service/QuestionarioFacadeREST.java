/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Questionario;
import entity.QuestionarioPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author stack
 */
@Stateless
@Path("entity.questionario")
public class QuestionarioFacadeREST extends AbstractFacade<Questionario> {

    @PersistenceContext(unitName = "UnirasmusServerPU")
    private EntityManager em;

    private QuestionarioPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idQuestionario=idQuestionarioValue;ente=enteValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entity.QuestionarioPK key = new entity.QuestionarioPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idQuestionario = map.get("idQuestionario");
        if (idQuestionario != null && !idQuestionario.isEmpty()) {
            key.setIdQuestionario(new java.lang.Integer(idQuestionario.get(0)));
        }
        java.util.List<String> ente = map.get("ente");
        if (ente != null && !ente.isEmpty()) {
            key.setEnte(new java.lang.Integer(ente.get(0)));
        }
        return key;
    }

    public QuestionarioFacadeREST() {
        super(Questionario.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Integer create(Questionario entity) {
        return super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Integer edit(@PathParam("id") PathSegment id, Questionario entity) {
        return super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public Integer remove(@PathParam("id") PathSegment id) {
        entity.QuestionarioPK key = getPrimaryKey(id);
        return super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Questionario find(@PathParam("id") PathSegment id) {
        entity.QuestionarioPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Questionario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Questionario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
