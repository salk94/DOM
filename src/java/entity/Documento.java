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
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findByIdDocumento", query = "SELECT d FROM Documento d WHERE d.idDocumento = :idDocumento")
    , @NamedQuery(name = "Documento.findByStato", query = "SELECT d FROM Documento d WHERE d.stato = :stato")
    , @NamedQuery(name = "Documento.findByNomeDocumento", query = "SELECT d FROM Documento d WHERE d.nomeDocumento = :nomeDocumento")
    , @NamedQuery(name = "Documento.findByUtenteUltimaModifica", query = "SELECT d FROM Documento d WHERE d.utenteUltimaModifica = :utenteUltimaModifica")
    , @NamedQuery(name = "Documento.findByDataOraModifica", query = "SELECT d FROM Documento d WHERE d.dataOraModifica = :dataOraModifica")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento")
    private Integer idDocumento;
    @Lob
    @Size(max = 65535)
    @Column(name = "commento")
    private String commento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stato")
    private int stato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_documento")
    private String nomeDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "utente_ultima_modifica")
    private String utenteUltimaModifica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_ora_modifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOraModifica;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "path")
    private String path;
    @JoinColumn(name = "erasmus", referencedColumnName = "id_erasmus")
    @ManyToOne(optional = false)
    private MobilitaErasmus erasmus;
    @JoinColumn(name = "studente", referencedColumnName = "id_studente")
    @ManyToOne(optional = false)
    private Studente studente;
    @JoinColumn(name = "tutor", referencedColumnName = "id_account")
    @ManyToOne(optional = false)
    private Account tutor;

    public Documento() {
    }

    public Documento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Documento(Integer idDocumento, int stato, String nomeDocumento, String utenteUltimaModifica, Date dataOraModifica, String path) {
        this.idDocumento = idDocumento;
        this.stato = stato;
        this.nomeDocumento = nomeDocumento;
        this.utenteUltimaModifica = utenteUltimaModifica;
        this.dataOraModifica = dataOraModifica;
        this.path = path;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

    public String getUtenteUltimaModifica() {
        return utenteUltimaModifica;
    }

    public void setUtenteUltimaModifica(String utenteUltimaModifica) {
        this.utenteUltimaModifica = utenteUltimaModifica;
    }

    public Date getDataOraModifica() {
        return dataOraModifica;
    }

    public void setDataOraModifica(Date dataOraModifica) {
        this.dataOraModifica = dataOraModifica;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MobilitaErasmus getErasmus() {
        return erasmus;
    }

    public void setErasmus(MobilitaErasmus erasmus) {
        this.erasmus = erasmus;
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
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Documento[ idDocumento=" + idDocumento + " ]";
    }
    
}
