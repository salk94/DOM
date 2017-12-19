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
@Table(name = "mobilita_erasmus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MobilitaErasmus.findAll", query = "SELECT m FROM MobilitaErasmus m")
    , @NamedQuery(name = "MobilitaErasmus.findByIdErasmus", query = "SELECT m FROM MobilitaErasmus m WHERE m.idErasmus = :idErasmus")
    , @NamedQuery(name = "MobilitaErasmus.findByStato", query = "SELECT m FROM MobilitaErasmus m WHERE m.stato = :stato")
    , @NamedQuery(name = "MobilitaErasmus.findByMatricola", query = "SELECT m FROM MobilitaErasmus m WHERE m.matricola = :matricola")
    , @NamedQuery(name = "MobilitaErasmus.findByDataInizio", query = "SELECT m FROM MobilitaErasmus m WHERE m.dataInizio = :dataInizio")
    , @NamedQuery(name = "MobilitaErasmus.findByDataFine", query = "SELECT m FROM MobilitaErasmus m WHERE m.dataFine = :dataFine")
    , @NamedQuery(name = "MobilitaErasmus.findByTutorEsterno", query = "SELECT m FROM MobilitaErasmus m WHERE m.tutorEsterno = :tutorEsterno")})
public class MobilitaErasmus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_erasmus")
    private Integer idErasmus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stato")
    private int stato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "matricola")
    private String matricola;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inizio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInizio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_fine")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFine;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tutor_esterno")
    private String tutorEsterno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erasmus")
    private Collection<Rinuncia> rinunciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erasmus")
    private Collection<Documento> documentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erasmus")
    private Collection<Esame> esameCollection;
    @JoinColumn(name = "ente", referencedColumnName = "id_ente")
    @ManyToOne(optional = false)
    private Ente ente;
    @JoinColumn(name = "studente", referencedColumnName = "id_studente")
    @ManyToOne(optional = false)
    private Studente studente;
    @JoinColumn(name = "tutor", referencedColumnName = "id_account")
    @ManyToOne(optional = false)
    private Account tutor;

    public MobilitaErasmus() {
    }

    public MobilitaErasmus(Integer idErasmus) {
        this.idErasmus = idErasmus;
    }

    public MobilitaErasmus(Integer idErasmus, int stato, String matricola, Date dataInizio, Date dataFine, String tutorEsterno) {
        this.idErasmus = idErasmus;
        this.stato = stato;
        this.matricola = matricola;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.tutorEsterno = tutorEsterno;
    }

    public Integer getIdErasmus() {
        return idErasmus;
    }

    public void setIdErasmus(Integer idErasmus) {
        this.idErasmus = idErasmus;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getTutorEsterno() {
        return tutorEsterno;
    }

    public void setTutorEsterno(String tutorEsterno) {
        this.tutorEsterno = tutorEsterno;
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

    public Ente getEnte() {
        return ente;
    }

    public void setEnte(Ente ente) {
        this.ente = ente;
    }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    public Account getTutor() {
        return tutor;
    }

    public void setTutor(Account tutor) {
        this.tutor = tutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idErasmus != null ? idErasmus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MobilitaErasmus)) {
            return false;
        }
        MobilitaErasmus other = (MobilitaErasmus) object;
        if ((this.idErasmus == null && other.idErasmus != null) || (this.idErasmus != null && !this.idErasmus.equals(other.idErasmus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MobilitaErasmus[ idErasmus=" + idErasmus + " ]";
    }
    
}
