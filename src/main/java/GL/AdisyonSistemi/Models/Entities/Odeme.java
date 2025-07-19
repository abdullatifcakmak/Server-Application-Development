package GL.AdisyonSistemi.Models.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "odemeler")
public class Odeme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* -------ManyToOne/Baslangic------- */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "masa_id")
    private Masa masa;

    /* -------ManyToOne/Bitis------- */

    @Column(name = "toplam_tutar")
    private double toplamTutar;

    @Column(name = "odeme_tarihi")
    @Temporal(TemporalType.DATE)
    private Date odemeTarihi;

    @Column(name = "odeme_sekli")
    private String odemeSekli;

    @Column(name="status")
    private Integer status;

    public Odeme(Masa masa, double toplamTutar, Date odemeTarihi, String odemeSekli, Integer status) {
        this.status = status;
        this.masa = masa;
        this.toplamTutar = toplamTutar;
        this.odemeTarihi = odemeTarihi;
        this.odemeSekli = odemeSekli;
    }

    /* -------OneToOne/Baslangic------- */

    @OneToOne
    @JoinColumn(name = "siparis_id", referencedColumnName = "id")
    @JsonIgnore
    private Siparis siparis;

    /* -------OneToOne/Bitis------- */
    // Getter ve Setter
    public Siparis getSiparis() {
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }

    public Odeme() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Masa getMasa() {
        return masa;
    }

    public void setMasa(Masa masa) {
        this.masa = masa;
    }

    public double getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(double toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public Date getOdemeTarihi() {
        return odemeTarihi;
    }

    public void setOdemeTarihi(Date odemeTarihi) {
        this.odemeTarihi = odemeTarihi;
    }

    public String getOdemeSekli() {
        return odemeSekli;
    }

    public void setOdemeSekli(String odemeSekli) {
        this.odemeSekli = odemeSekli;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
