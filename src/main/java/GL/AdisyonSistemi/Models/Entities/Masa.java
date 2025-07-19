package GL.AdisyonSistemi.Models.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "masalar")
public class Masa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    /* -------OneToMany/Baslangic------- */

    @OneToMany(mappedBy = "masa", fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Odeme>odemeler;

    /* -------OneToMany/Bitis------- */

    @Column(name = "numara", unique = true, nullable = false)
    private int numara;

    @Column(name = "durum", nullable = false)
    private String durum;

    @Column(name="toplam_tutar")
    private int toplamTutar;

    public Masa(int numara, String durum, int toplamTutar)
    {
        this.toplamTutar = toplamTutar;
        this.numara = numara;
        this.durum = durum;
    }

    public Masa() {
    }


}