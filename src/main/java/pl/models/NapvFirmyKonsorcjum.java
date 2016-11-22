/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author k.skowronski
 */
@Entity
@Table(name = "NAPV_FIRMY_KONSORCJUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NapvFirmyKonsorcjum.findAll", query = "SELECT n FROM NapvFirmyKonsorcjum n")
    , @NamedQuery(name = "NapvFirmyKonsorcjum.findByFrmId", query = "SELECT n FROM NapvFirmyKonsorcjum n WHERE n.frmId = :frmId")
    , @NamedQuery(name = "NapvFirmyKonsorcjum.findByFrmNazwa", query = "SELECT n FROM NapvFirmyKonsorcjum n WHERE n.frmNazwa = :frmNazwa")})
public class NapvFirmyKonsorcjum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRM_ID")
    private long frmId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FRM_NAZWA")
    private String frmNazwa;

    public NapvFirmyKonsorcjum() {
    }

    public long getFrmId() {
        return frmId;
    }

    public void setFrmId(long frmId) {
        this.frmId = frmId;
    }

    public String getFrmNazwa() {
        return frmNazwa;
    }

    public void setFrmNazwa(String frmNazwa) {
        this.frmNazwa = frmNazwa;
    }
    
}
