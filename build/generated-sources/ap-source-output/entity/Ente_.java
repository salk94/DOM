package entity;

import entity.Account;
import entity.Feedback;
import entity.MobilitaErasmus;
import entity.Questionario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(Ente.class)
public class Ente_ { 

    public static volatile SingularAttribute<Ente, String> vincolo;
    public static volatile SingularAttribute<Ente, Integer> ciclo;
    public static volatile SingularAttribute<Ente, Integer> numMobilita;
    public static volatile CollectionAttribute<Ente, Feedback> feedbackCollection;
    public static volatile SingularAttribute<Ente, String> nome;
    public static volatile CollectionAttribute<Ente, Questionario> questionarioCollection;
    public static volatile CollectionAttribute<Ente, MobilitaErasmus> mobilitaErasmusCollection;
    public static volatile SingularAttribute<Ente, String> paese;
    public static volatile SingularAttribute<Ente, Account> tutorAssociato;
    public static volatile SingularAttribute<Ente, String> linkEnte;
    public static volatile SingularAttribute<Ente, Integer> idEnte;
    public static volatile SingularAttribute<Ente, String> ambito;
    public static volatile SingularAttribute<Ente, String> telefono;
    public static volatile SingularAttribute<Ente, Date> fineAccordo;
    public static volatile SingularAttribute<Ente, String> email;

}