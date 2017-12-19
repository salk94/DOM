/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stack
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByIdAccount", query = "SELECT a FROM Account a WHERE a.idAccount = :idAccount")
    , @NamedQuery(name = "Account.findByNome", query = "SELECT a FROM Account a WHERE a.nome = :nome")
    , @NamedQuery(name = "Account.findByCognome", query = "SELECT a FROM Account a WHERE a.cognome = :cognome")
    , @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password")
    , @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email")
    , @NamedQuery(name = "Account.findByTipo", query = "SELECT a FROM Account a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Account.findByStato", query = "SELECT a FROM Account a WHERE a.stato = :stato")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_account")
    private Integer idAccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cognome")
    private String cognome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stato")
    private int stato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private Collection<Documento> documentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinatario")
    private Collection<Notifica> notificaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mittente")
    private Collection<Notifica> notificaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private Collection<MobilitaErasmus> mobilitaErasmusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutorAssociato")
    private Collection<Ente> enteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private Collection<Report> reportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private Collection<StudenteEntrante> studenteEntranteCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private Studente studente;

    public Account() {
    }

    public Account(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Account(Integer idAccount, String nome, String cognome, String password, String email, int tipo, int stato) {
        this.idAccount = idAccount;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.email = email;
        this.tipo = tipo;
        this.stato = stato;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Notifica> getNotificaCollection() {
        return notificaCollection;
    }

    public void setNotificaCollection(Collection<Notifica> notificaCollection) {
        this.notificaCollection = notificaCollection;
    }

    @XmlTransient
    public Collection<Notifica> getNotificaCollection1() {
        return notificaCollection1;
    }

    public void setNotificaCollection1(Collection<Notifica> notificaCollection1) {
        this.notificaCollection1 = notificaCollection1;
    }

    @XmlTransient
    public Collection<MobilitaErasmus> getMobilitaErasmusCollection() {
        return mobilitaErasmusCollection;
    }

    public void setMobilitaErasmusCollection(Collection<MobilitaErasmus> mobilitaErasmusCollection) {
        this.mobilitaErasmusCollection = mobilitaErasmusCollection;
    }

    @XmlTransient
    public Collection<Ente> getEnteCollection() {
        return enteCollection;
    }

    public void setEnteCollection(Collection<Ente> enteCollection) {
        this.enteCollection = enteCollection;
    }

    @XmlTransient
    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    @XmlTransient
    public Collection<StudenteEntrante> getStudenteEntranteCollection() {
        return studenteEntranteCollection;
    }

    public void setStudenteEntranteCollection(Collection<StudenteEntrante> studenteEntranteCollection) {
        this.studenteEntranteCollection = studenteEntranteCollection;
    }

    @XmlTransient
    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.idAccount == null && other.idAccount != null) || (this.idAccount != null && !this.idAccount.equals(other.idAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Account[ idAccount=" + idAccount + " ]";
    }
    
}
