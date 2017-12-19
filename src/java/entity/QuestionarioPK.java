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
public class QuestionarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_questionario")
    private int idQuestionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ente")
    private int ente;

    public QuestionarioPK() {
    }

    public QuestionarioPK(int idQuestionario, int ente) {
        this.idQuestionario = idQuestionario;
        this.ente = ente;
    }

    public int getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(int idQuestionario) {
        this.idQuestionario = idQuestionario;
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
        hash += (int) idQuestionario;
        hash += (int) ente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionarioPK)) {
            return false;
        }
        QuestionarioPK other = (QuestionarioPK) object;
        if (this.idQuestionario != other.idQuestionario) {
            return false;
        }
        if (this.ente != other.ente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.QuestionarioPK[ idQuestionario=" + idQuestionario + ", ente=" + ente + " ]";
    }
    
}
