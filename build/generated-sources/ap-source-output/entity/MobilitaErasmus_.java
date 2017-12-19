package entity;

import entity.Account;
import entity.Documento;
import entity.Ente;
import entity.Esame;
import entity.Rinuncia;
import entity.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(MobilitaErasmus.class)
public class MobilitaErasmus_ { 

    public static volatile SingularAttribute<MobilitaErasmus, Integer> stato;
    public static volatile SingularAttribute<MobilitaErasmus, Date> dataInizio;
    public static volatile CollectionAttribute<MobilitaErasmus, Rinuncia> rinunciaCollection;
    public static volatile CollectionAttribute<MobilitaErasmus, Esame> esameCollection;
    public static volatile SingularAttribute<MobilitaErasmus, String> tutorEsterno;
    public static volatile SingularAttribute<MobilitaErasmus, Ente> ente;
    public static volatile CollectionAttribute<MobilitaErasmus, Documento> documentoCollection;
    public static volatile SingularAttribute<MobilitaErasmus, Date> dataFine;
    public static volatile SingularAttribute<MobilitaErasmus, Integer> idErasmus;
    public static volatile SingularAttribute<MobilitaErasmus, Studente> studente;
    public static volatile SingularAttribute<MobilitaErasmus, String> matricola;
    public static volatile SingularAttribute<MobilitaErasmus, Account> tutor;

}