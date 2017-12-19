package entity;

import entity.ComposizioneReport;
import entity.RispostaReport;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-16T18:37:42")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile CollectionAttribute<Categoria, ComposizioneReport> composizioneReportCollection;
    public static volatile SingularAttribute<Categoria, String> nome;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile CollectionAttribute<Categoria, RispostaReport> rispostaReportCollection;

}