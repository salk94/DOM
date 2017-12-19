/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author stack
 */
@Embeddable
public class ComposizioneReportPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "report")
    private int report;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria")
    private int categoria;

    public ComposizioneReportPK() {
    }

    public ComposizioneReportPK(int report, int categoria) {
        this.report = report;
        this.categoria = categoria;
    }

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) report;
        hash += (int) categoria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComposizioneReportPK)) {
            return false;
        }
        ComposizioneReportPK other = (ComposizioneReportPK) object;
        if (this.report != other.report) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ComposizioneReportPK[ report=" + report + ", categoria=" + categoria + " ]";
    }
    
}
