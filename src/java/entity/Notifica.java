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
@Table(name = "notifica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notifica.findAll", query = "SELECT n FROM Notifica n")
    , @NamedQuery(name = "Notifica.findByIdNotifica", query = "SELECT n FROM Notifica n WHERE n.idNotifica = :idNotifica")
    , @NamedQuery(name = "Notifica.findByDataOraInvio", query = "SELECT n FROM Notifica n WHERE n.dataOraInvio = :dataOraInvio")})
public class Notifica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notifica")
    private Integer idNotifica;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "link_obiettivo")
    private String linkObiettivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_ora_invio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOraInvio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "contenuto")
    private String contenuto;
    @JoinColumn(name = "destinatario", referencedColumnName = "id_account")
    @ManyToOne(optional = false)
    private Account destinatario;
    @JoinColumn(name = "mittente", referencedColumnName = "id_account")
    @ManyToOne(optional = false)
    private Account mittente;

    public Notifica() {
    }

    public Notifica(Integer idNotifica) {
        this.idNotifica = idNotifica;
    }

    public Notifica(Integer idNotifica, String linkObiettivo, Date dataOraInvio, String contenuto) {
        this.idNotifica = idNotifica;
        this.linkObiettivo = linkObiettivo;
        this.dataOraInvio = dataOraInvio;
        this.contenuto = contenuto;
    }

    public Integer getIdNotifica() {
        return idNotifica;
    }

    public void setIdNotifica(Integer idNotifica) {
        this.idNotifica = idNotifica;
    }

    public String getLinkObiettivo() {
        return linkObiettivo;
    }

    public void setLinkObiettivo(String linkObiettivo) {
        this.linkObiettivo = linkObiettivo;
    }

    public Date getDataOraInvio() {
        return dataOraInvio;
    }

    public void setDataOraInvio(Date dataOraInvio) {
        this.dataOraInvio = dataOraInvio;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public Account getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Account destinatario) {
        this.destinatario = destinatario;
    }

    public Account getMittente() {
        return mittente;
    }

    public void setMittente(Account mittente) {
        this.mittente = mittente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotifica != null ? idNotifica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notifica)) {
            return false;
        }
        Notifica other = (Notifica) object;
        if ((this.idNotifica == null && other.idNotifica != null) || (this.idNotifica != null && !this.idNotifica.equals(other.idNotifica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Notifica[ idNotifica=" + idNotifica + " ]";
    }
    
}
