package entity;

import entity.Account;
import entity.ComposizioneReport;
import entity.RispostaReport;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(Report.class)
public class Report_ { 

    public static volatile SingularAttribute<Report, Integer> idReport;
    public static volatile SingularAttribute<Report, Date> dataCreazione;
    public static volatile CollectionAttribute<Report, ComposizioneReport> composizioneReportCollection;
    public static volatile CollectionAttribute<Report, RispostaReport> rispostaReportCollection;
    public static volatile SingularAttribute<Report, Integer> frequenza;
    public static volatile SingularAttribute<Report, Account> tutor;

}