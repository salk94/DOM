/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stack
 */
@Entity
@Table(name = "esame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esame.findAll", query = "SELECT e FROM Esame e")
    , @NamedQuery(name = "Esame.findByIdEsame", query = "SELECT e FROM Esame e WHERE e.idEsame = :idEsame")
    , @NamedQuery(name = "Esame.findByNomeEsame", query = "SELECT e FROM Esame e WHERE e.nomeEsame = :nomeEsame")
    , @NamedQuery(name = "Esame.findByProfessore", query = "SELECT e FROM Esame e WHERE e.professore = :professore")
    , @NamedQuery(name = "Esame.findByDataConvalida", query = "SELECT e FROM Esame e WHERE e.dataConvalida = :dataConvalida")
    , @NamedQuery(name = "Esame.findByEcts", query = "SELECT e FROM Esame e WHERE e.ects = :ects")
    , @NamedQuery(name = "Esame.findByValutazione", query = "SELECT e FROM Esame e WHERE e.valutazione = :valutazione")})
public class Esame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_esame")
    private Integer idEsame;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_esame")
    private String nomeEsame;
    @Size(max = 50)
    @Column(name = "professore")
    private String professore;
    @Column(name = "data_convalida")
    @Temporal(TemporalType.DATE)
    private Date dataConvalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ects")
    private int ects;
    @Column(name = "valutazione")
    private Integer valutazione;
    @JoinColumn(name = "erasmus", referencedColumnName = "id_erasmus")
    @ManyToOne(optional = false)
    private MobilitaErasmus erasmus;
    @JoinColumn(name = "studente", referencedColumnName = "id_studente")
    @ManyToOne(optional = false)
    private Studente studente;

    public Esame() {
    }

    public Esame(Integer idEsame) {
        this.idEsame = idEsame;
    }

    public Esame(Integer idEsame, String nomeEsame, int ects) {
        this.idEsame = idEsame;
        this.nomeEsame = nomeEsame;
        this.ects = ects;
    }

    public Integer getIdEsame() {
        return idEsame;
    }

    public void setIdEsame(Integer idEsame) {
        this.idEsame = idEsame;
    }

    public String getNomeEsame() {
        return nomeEsame;
    }

    public void setNomeEsame(String nomeEsame) {
        this.nomeEsame = nomeEsame;
    }

    public String getProfessore() {
        return professore;
    }

    public void setProfessore(String professore) {
        this.professore = professore;
    }

    public Date getDataConvalida() {
        return dataConvalida;
    }

    public void setDataConvalida(Date dataConvalida) {
        this.dataConvalida = dataConvalida;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public Integer getValutazione() {
        return valutazione;
    }

    public void setValutazione(Integer valutazione) {
        this.valutazione = valutazione;
    }

    public MobilitaErasmus getErasmus() {
        return erasmus;
    }

    public void setErasmus(MobilitaErasmus erasmus) {
        this.erasmus = erasmus;
    }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEsame != null ? idEsame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esame)) {
            return false;
        }
        Esame other = (Esame) object;
        if ((this.idEsame == null && other.idEsame != null) || (this.idEsame != null && !this.idEsame.equals(other.idEsame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Esame[ idEsame=" + idEsame + " ]";
    }
    
}
