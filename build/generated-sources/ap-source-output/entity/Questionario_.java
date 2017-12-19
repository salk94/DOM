package entity;

import entity.Ente;
import entity.QuestionarioPK;
import entity.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(Questionario.class)
public class Questionario_ { 

    public static volatile SingularAttribute<Questionario, Date> dataOra;
    public static volatile SingularAttribute<Questionario, String> svaghi;
    public static volatile SingularAttribute<Questionario, String> linkAlloggio;
    public static volatile SingularAttribute<Questionario, String> conoscenzeLinguistiche;
    public static volatile SingularAttribute<Questionario, Ente> ente1;
    public static volatile SingularAttribute<Questionario, Boolean> campus;
    public static volatile SingularAttribute<Questionario, String> repMatDid;
    public static volatile SingularAttribute<Questionario, String> trasporti;
    public static volatile SingularAttribute<Questionario, QuestionarioPK> questionarioPK;
    public static volatile SingularAttribute<Questionario, Studente> studente;
    public static volatile SingularAttribute<Questionario, String> alloggio;
    public static volatile SingularAttribute<Questionario, Integer> distanzaCitta;

}