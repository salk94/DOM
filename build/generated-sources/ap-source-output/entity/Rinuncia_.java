package entity;

import entity.MobilitaErasmus;
import entity.Studente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(Rinuncia.class)
public class Rinuncia_ { 

    public static volatile SingularAttribute<Rinuncia, String> motivo;
    public static volatile SingularAttribute<Rinuncia, Integer> idRinuncia;
    public static volatile SingularAttribute<Rinuncia, MobilitaErasmus> erasmus;
    public static volatile SingularAttribute<Rinuncia, Studente> studente;

}