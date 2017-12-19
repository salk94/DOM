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
public class FeedbackPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_feedback")
    private int idFeedback;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ente")
    private int ente;

    public FeedbackPK() {
    }

    public FeedbackPK(int idFeedback, int ente) {
        this.idFeedback = idFeedback;
        this.ente = ente;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public int getEnte() {
        return ente;
    }

    public void setEnte(int ente) {
        this.ente = ente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFeedback;
        hash += (int) ente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeedbackPK)) {
            return false;
        }
        FeedbackPK other = (FeedbackPK) object;
        if (this.idFeedback != other.idFeedback) {
            return false;
        }
        if (this.ente != other.ente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FeedbackPK[ idFeedback=" + idFeedback + ", ente=" + ente + " ]";
    }
    
}
