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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f")
    , @NamedQuery(name = "Feedback.findByIdFeedback", query = "SELECT f FROM Feedback f WHERE f.feedbackPK.idFeedback = :idFeedback")
    , @NamedQuery(name = "Feedback.findByDataOra", query = "SELECT f FROM Feedback f WHERE f.dataOra = :dataOra")
    , @NamedQuery(name = "Feedback.findByVoto", query = "SELECT f FROM Feedback f WHERE f.voto = :voto")
    , @NamedQuery(name = "Feedback.findByEnte", query = "SELECT f FROM Feedback f WHERE f.feedbackPK.ente = :ente")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FeedbackPK feedbackPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_ora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOra;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "commento")
    private String commento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "voto")
    private int voto;
    @JoinColumn(name = "ente", referencedColumnName = "id_ente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ente ente1;
    @JoinColumn(name = "studente", referencedColumnName = "id_studente")
    @ManyToOne(optional = false)
    private Studente studente;

    public Feedback() {
    }

    public Feedback(FeedbackPK feedbackPK) {
        this.feedbackPK = feedbackPK;
    }

    public Feedback(FeedbackPK feedbackPK, Date dataOra, String commento, int voto) {
        this.feedbackPK = feedbackPK;
        this.dataOra = dataOra;
        this.commento = commento;
        this.voto = voto;
    }

    public Feedback(int idFeedback, int ente) {
        this.feedbackPK = new FeedbackPK(idFeedback, ente);
    }

    public FeedbackPK getFeedbackPK() {
        return feedbackPK;
    }

    public void setFeedbackPK(FeedbackPK feedbackPK) {
        this.feedbackPK = feedbackPK;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public void setDataOra(Date dataOra) {
        this.dataOra = dataOra;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Ente getEnte1() {
        return ente1;
    }

    public void setEnte1(Ente ente1) {
        this.ente1 = ente1;
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
        hash += (feedbackPK != null ? feedbackPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.feedbackPK == null && other.feedbackPK != null) || (this.feedbackPK != null && !this.feedbackPK.equals(other.feedbackPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Feedback[ feedbackPK=" + feedbackPK + " ]";
    }
    
}
