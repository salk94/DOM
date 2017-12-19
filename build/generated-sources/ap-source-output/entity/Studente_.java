package entity;

import entity.Account;
import entity.Documento;
import entity.Esame;
import entity.Feedback;
import entity.MobilitaErasmus;
import entity.Questionario;
import entity.Rinuncia;
import entity.RispostaReport;
import entity.StudenteEntrante;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(Studente.class)
public class Studente_ { 

    public static volatile SingularAttribute<Studente, Integer> tipo;
    public static volatile SingularAttribute<Studente, Integer> idStudente;
    public static volatile SingularAttribute<Studente, Date> dataNascita;
    public static volatile CollectionAttribute<Studente, Documento> documentoCollection;
    public static volatile CollectionAttribute<Studente, Feedback> feedbackCollection;
    public static volatile SingularAttribute<Studente, StudenteEntrante> studenteEntrante;
    public static volatile CollectionAttribute<Studente, Questionario> questionarioCollection;
    public static volatile SingularAttribute<Studente, String> luogoNascita;
    public static volatile CollectionAttribute<Studente, RispostaReport> rispostaReportCollection;
    public static volatile CollectionAttribute<Studente, MobilitaErasmus> mobilitaErasmusCollection;
    public static volatile CollectionAttribute<Studente, Rinuncia> rinunciaCollection;
    public static volatile CollectionAttribute<Studente, Esame> esameCollection;
    public static volatile SingularAttribute<Studente, String> sesso;
    public static volatile SingularAttribute<Studente, String> matricola;
    public static volatile SingularAttribute<Studente, Account> account;

}