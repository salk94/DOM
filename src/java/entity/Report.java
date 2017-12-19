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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stack
 */
@Entity
@Table(name = "report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r")
    , @NamedQuery(name = "Report.findByIdReport", query = "SELECT r FROM Report r WHERE r.idReport = :idReport")
    , @NamedQuery(name = "Report.findByDataCreazione", query = "SELECT r FROM Report r WHERE r.dataCreazione = :dataCreazione")
    , @NamedQuery(name = "Report.findByFrequenza", query = "SELECT r FROM Report r WHERE r.frequenza = :frequenza")
    , @NamedQuery(name = "Report.findByTutor", query = "SELECT r FROM Report r WHERE r.tutor.idAccount = :idTutor")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_report")
    private Integer idReport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_creazione")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCreazione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frequenza")
    private int frequenza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "report")
    private Collection<ComposizioneReport> composizioneReportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "report")
    private Collection<RispostaReport> rispostaReportCollection;
    @JoinColumn(name = "tutor", referencedColumnName = "id_account")
    @ManyToOne(optional = false)
    private Account tutor;

    public Report() {
    }

    public Report(Integer idReport) {
        this.idReport = idReport;
    }

    public Report(Integer idReport, Date dataCreazione, int frequenza) {
        this.idReport = idReport;
        this.dataCreazione = dataCreazione;
        this.frequenza = frequenza;
    }

    public Integer getIdReport() {
        return idReport;
    }

    public void setIdReport(Integer idReport) {
        this.idReport = idReport;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public int getFrequenza() {
        return frequenza;
    }

    public void setFrequenza(int frequenza) {
        this.frequenza = frequenza;
    }

    @XmlTransient
    public Collection<ComposizioneReport> getComposizioneReportCollection() {
        return composizioneReportCollection;
    }

    public void setComposizioneReportCollection(Collection<ComposizioneReport> composizioneReportCollection) {
        this.composizioneReportCollection = composizioneReportCollection;
    }

    @XmlTransient
    public Collection<RispostaReport> getRispostaReportCollection() {
        return rispostaReportCollection;
    }

    public void setRispostaReportCollection(Collection<RispostaReport> rispostaReportCollection) {
        this.rispostaReportCollection = rispostaReportCollection;
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
        hash += (idReport != null ? idReport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.idReport == null && other.idReport != null) || (this.idReport != null && !this.idReport.equals(other.idReport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Report[ idReport=" + idReport + " ]";
    }
    
}
