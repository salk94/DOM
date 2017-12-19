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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "studente_entrante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudenteEntrante.findAll", query = "SELECT s FROM StudenteEntrante s")
    , @NamedQuery(name = "StudenteEntrante.findByIdAccount", query = "SELECT s FROM StudenteEntrante s WHERE s.idAccount = :idAccount")
    , @NamedQuery(name = "StudenteEntrante.findBySedeProvenienza", query = "SELECT s FROM StudenteEntrante s WHERE s.sedeProvenienza = :sedeProvenienza")
    , @NamedQuery(name = "StudenteEntrante.findByPaese", query = "SELECT s FROM StudenteEntrante s WHERE s.paese = :paese")
    , @NamedQuery(name = "StudenteEntrante.findByDataFine", query = "SELECT s FROM StudenteEntrante s WHERE s.dataFine = :dataFine")
    , @NamedQuery(name = "StudenteEntrante.findByDataInizio", query = "SELECT s FROM StudenteEntrante s WHERE s.dataInizio = :dataInizio")
    , @NamedQuery(name = "StudenteEntrante.findByNomeTutorEsterno", query = "SELECT s FROM StudenteEntrante s WHERE s.nomeTutorEsterno = :nomeTutorEsterno")})
public class StudenteEntrante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_account")
    private Integer idAccount;
    @Size(max = 50)
    @Column(name = "sede_provenienza")
    private String sedeProvenienza;
    @Size(max = 50)
    @Column(name = "paese")
    private String paese;
    @Column(name = "data_fine")
    @Temporal(TemporalType.DATE)
    private Date dataFine;
    @Column(name = "data_inizio")
    @Temporal(TemporalType.DATE)
    private Date dataInizio;
    @Lob
    @Size(max = 65535)
    @Column(name = "nota")
    private String nota;
    @Size(max = 50)
    @Column(name = "nome_tutor_esterno")
    private String nomeTutorEsterno;
    @JoinColumn(name = "id_account", referencedColumnName = "id_studente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Studente studente;
    @JoinColumn(name = "tutor", referencedColumnName = "id_account")
    @ManyToOne(optional = false)
    private Account tutor;

    public StudenteEntrante() {
    }

    public StudenteEntrante(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getSedeProvenienza() {
        return sedeProvenienza;
    }

    public void setSedeProvenienza(String sedeProvenienza) {
        this.sedeProvenienza = sedeProvenienza;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNomeTutorEsterno() {
        return nomeTutorEsterno;
    }

    public void setNomeTutorEsterno(String nomeTutorEsterno) {
        this.nomeTutorEsterno = nomeTutorEsterno;
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
        hash += (idAccount != null ? idAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudenteEntrante)) {
            return false;
        }
        StudenteEntrante other = (StudenteEntrante) object;
        if ((this.idAccount == null && other.idAccount != null) || (this.idAccount != null && !this.idAccount.equals(other.idAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StudenteEntrante[ idAccount=" + idAccount + " ]";
    }
    
}
