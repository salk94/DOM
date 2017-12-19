package entity;

import entity.Documento;
import entity.Ente;
import entity.MobilitaErasmus;
import entity.Notifica;
import entity.Report;
import entity.Studente;
import entity.StudenteEntrante;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, Integer> idAccount;
    public static volatile SingularAttribute<Account, Integer> tipo;
    public static volatile SingularAttribute<Account, String> cognome;
    public static volatile CollectionAttribute<Account, Documento> documentoCollection;
    public static volatile SingularAttribute<Account, String> nome;
    public static volatile CollectionAttribute<Account, MobilitaErasmus> mobilitaErasmusCollection;
    public static volatile CollectionAttribute<Account, Notifica> notificaCollection1;
    public static volatile SingularAttribute<Account, Integer> stato;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile CollectionAttribute<Account, Report> reportCollection;
    public static volatile CollectionAttribute<Account, Ente> enteCollection;
    public static volatile CollectionAttribute<Account, StudenteEntrante> studenteEntranteCollection;
    public static volatile SingularAttribute<Account, Studente> studente;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile CollectionAttribute<Account, Notifica> notificaCollection;

}