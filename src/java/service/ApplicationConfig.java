/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author stack
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.AccountFacadeREST.class);
        resources.add(service.CategoriaFacadeREST.class);
        resources.add(service.ComposizioneReportFacadeREST.class);
        resources.add(service.DocumentoFacadeREST.class);
        resources.add(service.EnteFacadeREST.class);
        resources.add(service.EsameFacadeREST.class);
        resources.add(service.FeedbackFacadeREST.class);
        resources.add(service.MobilitaErasmusFacadeREST.class);
        resources.add(service.NotificaFacadeREST.class);
        resources.add(service.QuestionarioFacadeREST.class);
        resources.add(service.ReportFacadeREST.class);
        resources.add(service.RinunciaFacadeREST.class);
        resources.add(service.RispostaReportFacadeREST.class);
        resources.add(service.StudenteEntranteFacadeREST.class);
        resources.add(service.StudenteFacadeREST.class);
    }
    
}
