/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stack
 */
@Entity
@Table(name = "studente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studente.findAll", query = "SELECT s FROM Studente s")
    , @NamedQuery(name = "Studente.findByIdStudente", query = "SELECT s FROM Studente s WHERE s.idStudente = :idStudente")
    , @NamedQuery(name = "Studente.findByTipo", query = "SELECT s FROM Studente s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Studente.findByMatricola", query = "SELECT s FROM Studente s WHERE s.matricola = :matricola")
    , @NamedQuery(name = "Studente.findByDataNascita", query = "SELECT s FROM Studente s WHERE s.dataNascita = :dataNascita")
    , @NamedQuery(name = "Studente.findByLuogoNascita", query = "SELECT s FROM Studente s WHERE s.luogoNascita = :luogoNascita")
    , @NamedQuery(name = "Studente.findBySesso", query = "SELECT s FROM Studente s WHERE s.sesso = :sesso")})
public class Studente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_studente")
    private Integer idStudente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "matricola")
    private String matricola;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascita")
    @Temporal(TemporalType.DATE)
    private Date dataNascita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "luogo_nascita")
    private String luogoNascita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sesso")
    private String sesso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studente")
    private Collection<Rinuncia> rinunciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studente")
    private Collection<Documento> documentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studente")
    private Collection<Esame> esameCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studente")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studente")
    private Collection<MobilitaErasmus> mobilitaErasmusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studente")
    private Collection<RispostaReport> rispostaReportCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studente")
    private StudenteEntrante studenteEntrante;
    @JoinColumn(name = "id_studente", referencedColumnName = "id_account", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studente")
    private Collection<Questionario> questionarioCollection;

    public Studente() {
    }

    public Studente(Integer idStudente) {
        this.idStudente = idStudente;
    }

    public Studente(Integer idStudente, int tipo, String matricola, Date dataNascita, String luogoNascita, String sesso) {
        this.idStudente = idStudente;
        this.tipo = tipo;
        this.matricola = matricola;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.sesso = sesso;
    }

    public Integer getIdStudente() {
        return idStudente;
    }

    public void setIdStudente(Integer idStudente) {
        this.idStudente = idStudente;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    @XmlTransient
    public Collection<Rinuncia> getRinunciaCollection() {
        return rinunciaCollection;
    }

    public void setRinunciaCollection(Collection<Rinuncia> rinunciaCollection) {
        this.rinunciaCollection = rinunciaCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Esame> getEsameCollection() {
        return esameCollection;
    }

    public void setEsameCollection(Collection<Esame> esameCollection) {
        this.esameCollection = esameCollection;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @XmlTransient
    public Collection<MobilitaErasmus> getMobilitaErasmusCollection() {
        return mobilitaErasmusCollection;
    }

    public void setMobilitaErasmusCollection(Collection<MobilitaErasmus> mobilitaErasmusCollection) {
        this.mobilitaErasmusCollection = mobilitaErasmusCollection;
    }

    @XmlTransient
    public Collection<RispostaReport> getRispostaReportCollection() {
        return rispostaReportCollection;
    }

    public void setRispostaReportCollection(Collection<RispostaReport> rispostaReportCollection) {
        this.rispostaReportCollection = rispostaReportCollection;
    }

    public StudenteEntrante getStudenteEntrante() {
        return studenteEntrante;
    }

    public void setStudenteEntrante(StudenteEntrante studenteEntrante) {
        this.studenteEntrante = studenteEntrante;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @XmlTransient
    public Collection<Questionario> getQuestionarioCollection() {
        return questionarioCollection;
    }

    public void setQuestionarioCollection(Collection<Questionario> questionarioCollection) {
        this.questionarioCollection = questionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudente != null ? idStudente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studente)) {
            return false;
        }
        Studente other = (Studente) object;
        if ((this.idStudente == null && other.idStudente != null) || (this.idStudente != null && !this.idStudente.equals(other.idStudente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Studente[ idStudente=" + idStudente + " ]";
    }
    
}
