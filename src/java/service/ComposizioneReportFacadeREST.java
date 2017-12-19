/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.ComposizioneReport;
import entity.ComposizioneReportPK;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author stack
 */
@Stateless
@Path("entity.composizionereport")
public class ComposizioneReportFacadeREST extends AbstractFacade<ComposizioneReport> {

    @PersistenceContext(unitName = "UnirasmusServerPU")
    private EntityManager em;

    private ComposizioneReportPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;report=reportValue;categoria=categoriaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entity.ComposizioneReportPK key = new entity.ComposizioneReportPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> report = map.get("report");
        if (report != null && !report.isEmpty()) {
            key.setReport(new java.lang.Integer(report.get(0)));
        }
        java.util.List<String> categoria = map.get("categoria");
        if (categoria != null && !categoria.isEmpty()) {
            key.setCategoria(new java.lang.Integer(categoria.get(0)));
        }
        return key;
    }

    public ComposizioneReportFacadeREST() {
        super(ComposizioneReport.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Integer create(ComposizioneReport entity) {
        return super.create(entity);
    }

    @PUT
    @Override
    @Path("edit")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Integer edit(ComposizioneReport entity) {
        return super.edit(entity);
    }

    @GET
    @Path("remove/{idReport}/{idCategoria}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer remove(@PathParam("idReport") Integer idReport, 
        @PathParam("idCategoria") Integer idCategoria) {
        ComposizioneReportPK idReportComposition = new ComposizioneReportPK();
        idReportComposition.setReport(idReport);
        idReportComposition.setCategoria(idCategoria);
        return super.remove(super.find(idReportComposition));
    }

    @GET
    @Path("find/{idReport}/{idCategoria}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ComposizioneReport find(@PathParam("idReport") Integer idReport, 
        @PathParam("idCategoria") Integer idCategoria) {
        ComposizioneReportPK idReportComposition = new ComposizioneReportPK();
        idReportComposition.setReport(idReport);
        idReportComposition.setCategoria(idCategoria);
        return super.find(idReportComposition);
    }

    @GET
    @Path("findAll")
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ComposizioneReport> findAll() {
        return super.findAll();
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
    
    //Modifica la domanda di una ComposizioneReport, dato un suo ID (composto)
    @GET
    @Path("changeQuestion/{idReport}/{idCategory}/{newQuestion}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer changeQuestion(@PathParam("idReport") Integer idReport, 
        @PathParam("idCategory") Integer idCategory, 
        @PathParam("newQuestion") String newQuestion) {
        ComposizioneReport reportComposition=find(idReport, idCategory);
        reportComposition.setDomanda(newQuestion);
        return edit(reportComposition);
    }
    
    
    //Ottiene la lista di ComposizioneReport di un certo report. Da esse posso accedere
    //alle categorie
    @GET
    @Path("findByReport/{idReport}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ComposizioneReport> findByReport(@PathParam("idReport") Integer idReport) {
        try {
            TypedQuery<ComposizioneReport> q=em.createNamedQuery("ComposizioneReport.findByReport", ComposizioneReport.class);
            q.setParameter("idReport", idReport);
            return q.getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    //Ottiene la lista di ComposizioneReport di una certa categoria. Da esse posso accedere
    //ai report
    @GET
    @Path("findByCategory/{idCategory}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ComposizioneReport> findByCategory(@PathParam("idCategory") Integer idCategory) {
        try {
            TypedQuery<ComposizioneReport> q=em.createNamedQuery("ComposizioneReport.findByCategoria", ComposizioneReport.class);
            q.setParameter("idCategoria", idCategory);
            return q.getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }
}
