package entity;

import entity.Account;
import entity.MobilitaErasmus;
import entity.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(Documento.class)
public class Documento_ { 

    public static volatile SingularAttribute<Documento, Integer> stato;
    public static volatile SingularAttribute<Documento, Date> dataOraModifica;
    public static volatile SingularAttribute<Documento, String> path;
    public static volatile SingularAttribute<Documento, Integer> idDocumento;
    public static volatile SingularAttribute<Documento, String> utenteUltimaModifica;
    public static volatile SingularAttribute<Documento, MobilitaErasmus> erasmus;
    public static volatile SingularAttribute<Documento, String> commento;
    public static volatile SingularAttribute<Documento, String> nomeDocumento;
    public static volatile SingularAttribute<Documento, Studente> studente;
    public static volatile SingularAttribute<Documento, Account> tutor;

}