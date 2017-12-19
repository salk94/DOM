package entity;

import entity.Account;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:43")
@StaticMetamodel(Notifica.class)
public class Notifica_ { 

    public static volatile SingularAttribute<Notifica, Date> dataOraInvio;
    public static volatile SingularAttribute<Notifica, Integer> idNotifica;
    public static volatile SingularAttribute<Notifica, Account> mittente;
    public static volatile SingularAttribute<Notifica, String> linkObiettivo;
    public static volatile SingularAttribute<Notifica, String> contenuto;
    public static volatile SingularAttribute<Notifica, Account> destinatario;

}