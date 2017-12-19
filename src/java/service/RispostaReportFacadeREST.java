/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.RispostaReport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("entity.rispostareport")
public class RispostaReportFacadeREST extends AbstractFacade<RispostaReport> {

    @PersistenceContext(unitName = "UnirasmusServerPU")
    private EntityManager em;

    public RispostaReportFacadeREST() {
        super(RispostaReport.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Integer create(RispostaReport entity) {
        return super.create(entity);
    }

    @PUT
    @Override
    @Path("edit")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Integer edit(RispostaReport entity) {
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
    public RispostaReport find(@PathParam("id") Integer id) {
        RispostaReport risposta =super.find(id);
        return risposta;
    }


    @GET
    @Override
    @Path("findAll")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RispostaReport> findAll() {
        return super.findAll();
    }


    @GET
    @Path("findRange/{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RispostaReport> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    
    //Metodi Business
    
    //Dato un report, ne torna tutte le risposte relative. Volendo, da quelle risposte
    //si può accedere alle info degli studenti.
    @GET
    @Path("findByReport/{idReport}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RispostaReport> findByReport(@PathParam("idReport") Integer idReport) {
        try {
            TypedQuery<RispostaReport> q=em.createNamedQuery("RispostaReport.findByReport", RispostaReport.class);
            q.setParameter("idReport", idReport);
            return q.getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    //Dato uno studente, ne torne tutte le risposte che ha fatto. Volendo, da quelle risposte
    //si può accedere al Report.
    @GET
    @Path("findByStudent/{idStudent}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RispostaReport> findByStudent(@PathParam("idStudent") Integer idStudent) {
        try {
            TypedQuery<RispostaReport> q=em.createNamedQuery("RispostaReport.findByStudente", RispostaReport.class);
            q.setParameter("idStudente", idStudent);
            return q.getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    //Dato un report ed uno studente, ne torna tutte le risposte relative.
    @GET
    @Path("findByReportAndStudent/{idReport}/{idStudent}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RispostaReport> findByReportAndStudent(@PathParam("idReport") Integer idReport, 
            @PathParam("idStudent") Integer idStudent) {
        try {
            TypedQuery<RispostaReport> q=em.createNamedQuery("RispostaReport.findByReportAndStudente", RispostaReport.class);
            q.setParameter("idReport", idReport);
            q.setParameter("idStudente", idStudent);
            return q.getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    //Dato un report ed una data, ritorna le risposte in quella data: 
    //Query che cerca le risposte nel range di quella data
    //da 00:00 alle 23:59 dello stesso giorno specificato dal parametro
    @GET
    @Path("findByReportInDate/{idReport}/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RispostaReport> findByReportInDate(@PathParam("idReport") Integer idReport, 
            @PathParam("date") String date) {
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date dateStart=sdf.parse(date + " 00:00:00");
            Date dateEnd=sdf.parse(date + " 23:59:59");
            TypedQuery<RispostaReport> q=em.createNamedQuery("RispostaReport.findByReportInData", RispostaReport.class);
            q.setParameter("idReport", idReport);
            q.setParameter("dataOraRispostaStart", dateStart, TemporalType.TIMESTAMP);
            q.setParameter("dataOraRispostaEnd", dateEnd, TemporalType.TIMESTAMP);
            return q.getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    //Dato uno studente ed una data, ritorna le risposte dello studente in quella data: 
    //Query che cerca le risposte nel range di quella data
    //da 00:00 alle 23:59 dello stesso giorno specificato dal parametro
    @GET
    @Path("findByStudentInDate/{idStudent}/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RispostaReport> findByStudentInDate(@PathParam("idStudent") Integer idStudent, 
            @PathParam("date") String date) {
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date dateStart=sdf.parse(date + " 00:00:00");
            Date dateEnd=sdf.parse(date + " 23:59:59");
            TypedQuery<RispostaReport> q=em.createNamedQuery("RispostaReport.findByStudenteInData", RispostaReport.class);
            q.setParameter("idStudente", idStudent);
            q.setParameter("dataOraRispostaStart", dateStart, TemporalType.TIMESTAMP);
            q.setParameter("dataOraRispostaEnd", dateEnd, TemporalType.TIMESTAMP);
            return q.getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    //Dato un report ed due date, ritorna le risposte in quel range di date: 
    //Query che cerca le risposte nel range di quelle date (00:00 alle 23:59).
    @GET
    @Path("findByReportInDateRange/{idReport}/{dateInf}/{dateSup}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RispostaReport> findByReportInDateRange(@PathParam("idReport") Integer idReport, 
            @PathParam("dateInf") String dateInf, @PathParam("dateSup") String dateSup) {
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date dateInfStart=sdf.parse(dateInf + " 00:00:00");
            Date dateSupEnd=sdf.parse(dateSup + " 23:59:59");
            if(dateInfStart.before(dateSupEnd)) {
                TypedQuery<RispostaReport> q=em.createNamedQuery("RispostaReport.findByReportInDataRange", RispostaReport.class);
                q.setParameter("idReport", idReport);
                q.setParameter("dataOraRispostaInfStart", dateInfStart, TemporalType.TIMESTAMP);
                q.setParameter("dataOraRispostaSupEnd", dateSupEnd, TemporalType.TIMESTAMP);
                return q.getResultList();
            }
            else {
                throw new RuntimeException();
            }
        }
        catch (Exception e) {
            return null;
        }
    }
    
    //Dato uno studente ed due date, ritorna le risposte in quel range di date: 
    //Query che cerca le risposte nel range di quelle date (00:00 alle 23:59).
    @GET
    @Path("findByStudentInDateRange/{idStudent}/{dateInf}/{dateSup}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RispostaReport> findByStudentInDateRange(@PathParam("idStudent") Integer idStudent, 
            @PathParam("dateInf") String dateInf, @PathParam("dateSup") String dateSup) {
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date dateInfStart=sdf.parse(dateInf + " 00:00:00");
            Date dateSupEnd=sdf.parse(dateSup + " 23:59:59");
            if(dateInfStart.before(dateSupEnd)) {
                TypedQuery<RispostaReport> q=em.createNamedQuery("RispostaReport.findByStudenteInDataRange", RispostaReport.class);
                q.setParameter("idStudente", idStudent);
                q.setParameter("dataOraRispostaInfStart", dateInfStart, TemporalType.TIMESTAMP);
                q.setParameter("dataOraRispostaSupEnd", dateSupEnd, TemporalType.TIMESTAMP);
                return q.getResultList();
            }
            else {
                throw new RuntimeException();
            }
        }
        catch (Exception e) {
            return null;
        }
    }
}
