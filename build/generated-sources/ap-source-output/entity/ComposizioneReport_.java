package entity;

import entity.Categoria;
import entity.ComposizioneReportPK;
import entity.Report;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:43")
@StaticMetamodel(ComposizioneReport.class)
public class ComposizioneReport_ { 

    public static volatile SingularAttribute<ComposizioneReport, Categoria> categoria;
    public static volatile SingularAttribute<ComposizioneReport, ComposizioneReportPK> composizioneReportPK;
    public static volatile SingularAttribute<ComposizioneReport, Report> report;
    public static volatile SingularAttribute<ComposizioneReport, String> domanda;

}