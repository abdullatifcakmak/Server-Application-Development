package GL.AdisyonSistemi.Services.Contracts;



import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;
import GL.AdisyonSistemi.Models.Entities.Siparis;

import java.util.List;

public interface OdemeServiceInterface {
    void save(Odeme odeme);
    Odeme findById(Integer id);
    void update(Odeme odeme);
    void odemeYap(Odeme odeme);
    void delete(Integer id);
    List<Odeme> findAll();
    Siparis findSiparisOdemeId(Integer id);
    Masa findMasaOdemeId(Integer id);
}
