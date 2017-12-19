/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Report;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author stack
 */
@Stateless
@Path("entity.report")
public class ReportFacadeREST extends AbstractFacade<Report> {

    @PersistenceContext(unitName = "UnirasmusServerPU")
    private EntityManager em;

    public ReportFacadeREST() {
        super(Report.class);
    }
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Integer create(Report entity) {
        return super.create(entity);
    }

    @PUT
    @Override
    @Path("edit")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Integer edit(Report entity) {
        return super.edit(entity);
    }
    
    @GET
    @Path("remove/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer remove(@PathParam("id") Integer id) {
        return super.remove(super.find(id));
    }

    @GET
    @Path("find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Report find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Path("findAll")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findAll() {
        return super.findAll();
    }

    @GET
    @Path("findRange/{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    //Metodi di business

    //Ricerca tutti e soli i report di un certo tutor, tramite il suo id.
    @GET
    @Path("findByTutor/{idTutor}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findByTutor(@PathParam("idTutor") Integer idTutor) {
        try {
            TypedQuery<Report> q=em.createNamedQuery("Report.findByTutor", Report.class);
            q.setParameter("idTutor", idTutor);
            return q.getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    //Modifica la frequenza di un report, tramite il suo id.
    @GET
    @Path("changeFrequency/{id}/{newFrequency}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer changeFrequency(@PathParam("id") Integer idReport, @PathParam("newFrequency") int newFrequency) {
        Report report=find(idReport);
        report.setFrequenza(newFrequency);
        return edit(report);
    }
}