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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ente.findAll", query = "SELECT e FROM Ente e")
    , @NamedQuery(name = "Ente.findByIdEnte", query = "SELECT e FROM Ente e WHERE e.idEnte = :idEnte")
    , @NamedQuery(name = "Ente.findByNome", query = "SELECT e FROM Ente e WHERE e.nome = :nome")
    , @NamedQuery(name = "Ente.findByPaese", query = "SELECT e FROM Ente e WHERE e.paese = :paese")
    , @NamedQuery(name = "Ente.findByEmail", query = "SELECT e FROM Ente e WHERE e.email = :email")
    , @NamedQuery(name = "Ente.findByTelefono", query = "SELECT e FROM Ente e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Ente.findByCiclo", query = "SELECT e FROM Ente e WHERE e.ciclo = :ciclo")
    , @NamedQuery(name = "Ente.findByFineAccordo", query = "SELECT e FROM Ente e WHERE e.fineAccordo = :fineAccordo")
    , @NamedQuery(name = "Ente.findByNumMobilita", query = "SELECT e FROM Ente e WHERE e.numMobilita = :numMobilita")})
public class Ente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ente")
    private Integer idEnte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "paese")
    private String paese;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Lob
    @Size(max = 65535)
    @Column(name = "link_ente")
    private String linkEnte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ciclo")
    private int ciclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fine_accordo")
    @Temporal(TemporalType.DATE)
    private Date fineAccordo;
    @Lob
    @Size(max = 65535)
    @Column(name = "vincolo")
    private String vincolo;
    @Lob
    @Size(max = 65535)
    @Column(name = "ambito")
    private String ambito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_mobilita")
    private int numMobilita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ente1")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ente")
    private Collection<MobilitaErasmus> mobilitaErasmusCollection;
    @JoinColumn(name = "tutor_associato", referencedColumnName = "id_account")
    @ManyToOne(optional = false)
    private Account tutorAssociato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ente1")
    private Collection<Questionario> questionarioCollection;

    public Ente() {
    }

    public Ente(Integer idEnte) {
        this.idEnte = idEnte;
    }

    public Ente(Integer idEnte, String nome, String paese, int ciclo, Date fineAccordo, int numMobilita) {
        this.idEnte = idEnte;
        this.nome = nome;
        this.paese = paese;
        this.ciclo = ciclo;
        this.fineAccordo = fineAccordo;
        this.numMobilita = numMobilita;
    }

    public Integer getIdEnte() {
        return idEnte;
    }

    public void setIdEnte(Integer idEnte) {
        this.idEnte = idEnte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLinkEnte() {
        return linkEnte;
    }

    public void setLinkEnte(String linkEnte) {
        this.linkEnte = linkEnte;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public Date getFineAccordo() {
        return fineAccordo;
    }

    public void setFineAccordo(Date fineAccordo) {
        this.fineAccordo = fineAccordo;
    }

    public String getVincolo() {
        return vincolo;
    }

    public void setVincolo(String vincolo) {
        this.vincolo = vincolo;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public int getNumMobilita() {
        return numMobilita;
    }

    public void setNumMobilita(int numMobilita) {
        this.numMobilita = numMobilita;
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

    public Account getTutorAssociato() {
        return tutorAssociato;
    }

    public void setTutorAssociato(Account tutorAssociato) {
        this.tutorAssociato = tutorAssociato;
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
        hash += (idEnte != null ? idEnte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ente)) {
            return false;
        }
        Ente other = (Ente) object;
        if ((this.idEnte == null && other.idEnte != null) || (this.idEnte != null && !this.idEnte.equals(other.idEnte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ente[ idEnte=" + idEnte + " ]";
    }
    
}
