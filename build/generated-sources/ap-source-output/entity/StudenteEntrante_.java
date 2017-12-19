package entity;

import entity.Account;
import entity.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(StudenteEntrante.class)
public class StudenteEntrante_ { 

    public static volatile SingularAttribute<StudenteEntrante, String> nomeTutorEsterno;
    public static volatile SingularAttribute<StudenteEntrante, Integer> idAccount;
    public static volatile SingularAttribute<StudenteEntrante, String> paese;
    public static volatile SingularAttribute<StudenteEntrante, Date> dataInizio;
    public static volatile SingularAttribute<StudenteEntrante, Date> dataFine;
    public static volatile SingularAttribute<StudenteEntrante, Studente> studente;
    public static volatile SingularAttribute<StudenteEntrante, String> nota;
    public static volatile SingularAttribute<StudenteEntrante, String> sedeProvenienza;
    public static volatile SingularAttribute<StudenteEntrante, Account> tutor;

}