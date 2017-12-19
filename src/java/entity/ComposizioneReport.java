/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stack
 */
@Entity
@Table(name = "composizione_report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComposizioneReport.findAll", query = "SELECT c FROM ComposizioneReport c")
    , @NamedQuery(name = "ComposizioneReport.findByReport", query = "SELECT c FROM ComposizioneReport c WHERE c.composizioneReportPK.report = :idReport")
    , @NamedQuery(name = "ComposizioneReport.findByCategoria", query = "SELECT c FROM ComposizioneReport c WHERE c.composizioneReportPK.categoria = :idCategoria")
    , @NamedQuery(name = "ComposizioneReport.findByDomanda", query = "SELECT c FROM ComposizioneReport c WHERE c.domanda = :domanda")
})
public class ComposizioneReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComposizioneReportPK composizioneReportPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "domanda")
    private String domanda;
    @JoinColumn(name = "categoria", referencedColumnName = "id_categoria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "report", referencedColumnName = "id_report", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Report report;

    public ComposizioneReport() {
    }

    public ComposizioneReport(ComposizioneReportPK composizioneReportPK) {
        this.composizioneReportPK = composizioneReportPK;
    }

    public ComposizioneReport(ComposizioneReportPK composizioneReportPK, String domanda) {
        this.composizioneReportPK = composizioneReportPK;
        this.domanda = domanda;
    }

    public ComposizioneReport(int report, int categoria) {
        this.composizioneReportPK = new ComposizioneReportPK(report, categoria);
    }

    public ComposizioneReportPK getComposizioneReportPK() {
        return composizioneReportPK;
    }

    public void setComposizioneReportPK(ComposizioneReportPK composizioneReportPK) {
        this.composizioneReportPK = composizioneReportPK;
    }

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria1) {
        this.categoria = categoria1;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (composizioneReportPK != null ? composizioneReportPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComposizioneReport)) {
            return false;
        }
        ComposizioneReport other = (ComposizioneReport) object;
        if ((this.composizioneReportPK == null && other.composizioneReportPK != null) || (this.composizioneReportPK != null && !this.composizioneReportPK.equals(other.composizioneReportPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ComposizioneReport[ composizioneReportPK=" + composizioneReportPK + " ]";
    }
    
}
