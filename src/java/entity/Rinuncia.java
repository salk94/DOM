/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stack
 */
@Entity
@Table(name = "rinuncia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rinuncia.findAll", query = "SELECT r FROM Rinuncia r")
    , @NamedQuery(name = "Rinuncia.findByIdRinuncia", query = "SELECT r FROM Rinuncia r WHERE r.idRinuncia = :idRinuncia")})
public class Rinuncia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rinuncia")
    private Integer idRinuncia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "motivo")
    private String motivo;
    @JoinColumn(name = "erasmus", referencedColumnName = "id_erasmus")
    @ManyToOne(optional = false)
    private MobilitaErasmus erasmus;
    @JoinColumn(name = "studente", referencedColumnName = "id_studente")
    @ManyToOne(optional = false)
    private Studente studente;

    public Rinuncia() {
    }

    public Rinuncia(Integer idRinuncia) {
        this.idRinuncia = idRinuncia;
    }

    public Rinuncia(Integer idRinuncia, String motivo) {
        this.idRinuncia = idRinuncia;
        this.motivo = motivo;
    }

    public Integer getIdRinuncia() {
        return idRinuncia;
    }

    public void setIdRinuncia(Integer idRinuncia) {
        this.idRinuncia = idRinuncia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRinuncia != null ? idRinuncia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rinuncia)) {
            return false;
        }
        Rinuncia other = (Rinuncia) object;
        if ((this.idRinuncia == null && other.idRinuncia != null) || (this.idRinuncia != null && !this.idRinuncia.equals(other.idRinuncia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rinuncia[ idRinuncia=" + idRinuncia + " ]";
    }
    
}
