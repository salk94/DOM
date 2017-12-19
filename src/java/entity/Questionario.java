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
@Table(name = "questionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questionario.findAll", query = "SELECT q FROM Questionario q")
    , @NamedQuery(name = "Questionario.findByIdQuestionario", query = "SELECT q FROM Questionario q WHERE q.questionarioPK.idQuestionario = :idQuestionario")
    , @NamedQuery(name = "Questionario.findByDistanzaCitta", query = "SELECT q FROM Questionario q WHERE q.distanzaCitta = :distanzaCitta")
    , @NamedQuery(name = "Questionario.findByDataOra", query = "SELECT q FROM Questionario q WHERE q.dataOra = :dataOra")
    , @NamedQuery(name = "Questionario.findByCampus", query = "SELECT q FROM Questionario q WHERE q.campus = :campus")
    , @NamedQuery(name = "Questionario.findByEnte", query = "SELECT q FROM Questionario q WHERE q.questionarioPK.ente = :ente")})
public class Questionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuestionarioPK questionarioPK;
    @Lob
    @Size(max = 65535)
    @Column(name = "svaghi")
    private String svaghi;
    @Lob
    @Size(max = 65535)
    @Column(name = "trasporti")
    private String trasporti;
    @Lob
    @Size(max = 65535)
    @Column(name = "rep_mat_did")
    private String repMatDid;
    @Lob
    @Size(max = 65535)
    @Column(name = "alloggio")
    private String alloggio;
    @Lob
    @Size(max = 65535)
    @Column(name = "link_alloggio")
    private String linkAlloggio;
    @Column(name = "distanza_citta")
    private Integer distanzaCitta;
    @Lob
    @Size(max = 65535)
    @Column(name = "conoscenze_linguistiche")
    private String conoscenzeLinguistiche;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_ora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "campus")
    private boolean campus;
    @JoinColumn(name = "ente", referencedColumnName = "id_ente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ente ente1;
    @JoinColumn(name = "studente", referencedColumnName = "id_studente")
    @ManyToOne(optional = false)
    private Studente studente;

    public Questionario() {
    }

    public Questionario(QuestionarioPK questionarioPK) {
        this.questionarioPK = questionarioPK;
    }

    public Questionario(QuestionarioPK questionarioPK, Date dataOra, boolean campus) {
        this.questionarioPK = questionarioPK;
        this.dataOra = dataOra;
        this.campus = campus;
    }

    public Questionario(int idQuestionario, int ente) {
        this.questionarioPK = new QuestionarioPK(idQuestionario, ente);
    }

    public QuestionarioPK getQuestionarioPK() {
        return questionarioPK;
    }

    public void setQuestionarioPK(QuestionarioPK questionarioPK) {
        this.questionarioPK = questionarioPK;
    }

    public String getSvaghi() {
        return svaghi;
    }

    public void setSvaghi(String svaghi) {
        this.svaghi = svaghi;
    }

    public String getTrasporti() {
        return trasporti;
    }

    public void setTrasporti(String trasporti) {
        this.trasporti = trasporti;
    }

    public String getRepMatDid() {
        return repMatDid;
    }

    public void setRepMatDid(String repMatDid) {
        this.repMatDid = repMatDid;
    }

    public String getAlloggio() {
        return alloggio;
    }

    public void setAlloggio(String alloggio) {
        this.alloggio = alloggio;
    }

    public String getLinkAlloggio() {
        return linkAlloggio;
    }

    public void setLinkAlloggio(String linkAlloggio) {
        this.linkAlloggio = linkAlloggio;
    }

    public Integer getDistanzaCitta() {
        return distanzaCitta;
    }

    public void setDistanzaCitta(Integer distanzaCitta) {
        this.distanzaCitta = distanzaCitta;
    }

    public String getConoscenzeLinguistiche() {
        return conoscenzeLinguistiche;
    }

    public void setConoscenzeLinguistiche(String conoscenzeLinguistiche) {
        this.conoscenzeLinguistiche = conoscenzeLinguistiche;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public void setDataOra(Date dataOra) {
        this.dataOra = dataOra;
    }

    public boolean getCampus() {
        return campus;
    }

    public void setCampus(boolean campus) {
        this.campus = campus;
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
        hash += (questionarioPK != null ? questionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionario)) {
            return false;
        }
        Questionario other = (Questionario) object;
        if ((this.questionarioPK == null && other.questionarioPK != null) || (this.questionarioPK != null && !this.questionarioPK.equals(other.questionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Questionario[ questionarioPK=" + questionarioPK + " ]";
    }
    
}
