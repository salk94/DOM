package entity;

import entity.MobilitaErasmus;
import entity.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:43")
@StaticMetamodel(Esame.class)
public class Esame_ { 

    public static volatile SingularAttribute<Esame, Integer> ects;
    public static volatile SingularAttribute<Esame, Integer> idEsame;
    public static volatile SingularAttribute<Esame, MobilitaErasmus> erasmus;
    public static volatile SingularAttribute<Esame, String> professore;
    public static volatile SingularAttribute<Esame, Studente> studente;
    public static volatile SingularAttribute<Esame, Date> dataConvalida;
    public static volatile SingularAttribute<Esame, String> nomeEsame;
    public static volatile SingularAttribute<Esame, Integer> valutazione;

}