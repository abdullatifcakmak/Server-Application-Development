package GL.AdisyonSistemi.Models.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "siparisler")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "urun_adi")
    private String urunAdi;

    @Column(name = "fiyat")
    private double fiyat;

    @Column(name = "miktar")
    private int miktar;

    @JoinColumn(name = "masa_id")
    private int masaId;

    public Siparis( String urunAdi, double fiyat, int miktar, int masaId ) {
        this.masaId = masaId;
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
        this.miktar = miktar;
    }


    @OneToOne(mappedBy = "siparis", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Odeme odeme;

    public Odeme getOdeme() {
        return odeme;
    }

    public void setOdeme(Odeme odeme) {
        this.odeme = odeme;
    }



    public Siparis() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public double getToplamFiyat() {
        return fiyat * miktar; // Toplam fiyatı hesapla
    }

    public int getMasaId() {
        return masaId;
    }

    public void setMasaId(int masaId) {
        this.masaId = masaId;
    }
}
