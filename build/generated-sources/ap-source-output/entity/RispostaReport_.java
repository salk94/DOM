package entity;

import entity.Categoria;
import entity.Report;
import entity.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:43")
@StaticMetamodel(RispostaReport.class)
public class RispostaReport_ { 

    public static volatile SingularAttribute<RispostaReport, Integer> reazione;
    public static volatile SingularAttribute<RispostaReport, Date> dataOraRisposta;
    public static volatile SingularAttribute<RispostaReport, Integer> idRisposta;
    public static volatile SingularAttribute<RispostaReport, String> risposta;
    public static volatile SingularAttribute<RispostaReport, Categoria> categoria;
    public static volatile SingularAttribute<RispostaReport, Report> report;
    public static volatile SingularAttribute<RispostaReport, String> domanda;
    public static volatile SingularAttribute<RispostaReport, Studente> studente;

}