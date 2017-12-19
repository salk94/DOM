package entity;

import entity.Ente;
import entity.FeedbackPK;
import entity.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Date> dataOra;
    public static volatile SingularAttribute<Feedback, Integer> voto;
    public static volatile SingularAttribute<Feedback, Ente> ente1;
    public static volatile SingularAttribute<Feedback, String> commento;
    public static volatile SingularAttribute<Feedback, FeedbackPK> feedbackPK;
    public static volatile SingularAttribute<Feedback, Studente> studente;

}