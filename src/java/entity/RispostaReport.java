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
import javax.persistence.Lob;
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
@Table(name = "risposta_report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RispostaReport.findAll", query = "SELECT r FROM RispostaReport r")
    , @NamedQuery(name = "RispostaReport.findByIdRisposta", query = "SELECT r FROM RispostaReport r WHERE r.idRisposta = :idRisposta")
    , @NamedQuery(name = "RispostaReport.findByDataOraRisposta", query = "SELECT r FROM RispostaReport r WHERE r.dataOraRisposta = :dataOraRisposta")
    , @NamedQuery(name = "RispostaReport.findByDomanda", query = "SELECT r FROM RispostaReport r WHERE r.domanda = :domanda")
    , @NamedQuery(name = "RispostaReport.findByReazione", query = "SELECT r FROM RispostaReport r WHERE r.reazione = :reazione")
    , @NamedQuery(name = "RispostaReport.findByReport", query = "SELECT r FROM RispostaReport r WHERE r.report.idReport = :idReport")
    , @NamedQuery(name = "RispostaReport.findByStudente", query = "SELECT r FROM RispostaReport r WHERE r.studente.idStudente = :idStudente")
    , @NamedQuery(name = "RispostaReport.findByReportAndStudente", query = "SELECT r FROM RispostaReport r WHERE r.report.idReport = :idReport AND r.studente.idStudente = :idStudente")
    , @NamedQuery(name = "RispostaReport.findByReportInData", query = "SELECT r FROM RispostaReport r WHERE r.report.idReport = :idReport AND r.dataOraRisposta BETWEEN :dataOraRispostaStart AND :dataOraRispostaEnd")
    , @NamedQuery(name = "RispostaReport.findByStudenteInData", query = "SELECT r FROM RispostaReport r WHERE r.studente.idStudente = :idStudente AND r.dataOraRisposta BETWEEN :dataOraRispostaStart AND :dataOraRispostaEnd")
    , @NamedQuery(name = "RispostaReport.findByReportInDataRange", query = "SELECT r FROM RispostaReport r WHERE r.report.idReport = :idReport AND r.dataOraRisposta BETWEEN :dataOraRispostaInfStart AND :dataOraRispostaSupEnd")
    , @NamedQuery(name = "RispostaReport.findByStudenteInDataRange", query = "SELECT r FROM RispostaReport r WHERE r.studente.idStudente= :idStudente AND r.dataOraRisposta BETWEEN :dataOraRispostaInfStart AND :dataOraRispostaSupEnd")
})
public class RispostaReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_risposta")
    private Integer idRisposta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_ora_risposta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOraRisposta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "domanda")
    private String domanda;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "risposta")
    private String risposta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reazione")
    private int reazione;
    @JoinColumn(name = "categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "report", referencedColumnName = "id_report")
    @ManyToOne(optional = false)
    private Report report;
    @JoinColumn(name = "studente", referencedColumnName = "id_studente")
    @ManyToOne(optional = false)
    private Studente studente;

    public RispostaReport() {
    }

    public RispostaReport(Integer idRisposta) {
        this.idRisposta = idRisposta;
    }

    public RispostaReport(Integer idRisposta, Date dataOraRisposta, String domanda, String risposta, int reazione) {
        this.idRisposta = idRisposta;
        this.dataOraRisposta = dataOraRisposta;
        this.domanda = domanda;
        this.risposta = risposta;
        this.reazione = reazione;
    }

    public Integer getIdRisposta() {
        return idRisposta;
    }

    public void setIdRisposta(Integer idRisposta) {
        this.idRisposta = idRisposta;
    }

    public Date getDataOraRisposta() {
        return dataOraRisposta;
    }

    public void setDataOraRisposta(Date dataOraRisposta) {
        this.dataOraRisposta = dataOraRisposta;
    }

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    public int getReazione() {
        return reazione;
    }

    public void setReazione(int reazione) {
        this.reazione = reazione;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
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
        hash += (idRisposta != null ? idRisposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RispostaReport)) {
            return false;
        }
        RispostaReport other = (RispostaReport) object;
        if ((this.idRisposta == null && other.idRisposta != null) || (this.idRisposta != null && !this.idRisposta.equals(other.idRisposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RispostaReport[ idRisposta=" + idRisposta + " ]";
    }
    
}
