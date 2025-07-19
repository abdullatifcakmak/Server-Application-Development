package GL.AdisyonSistemi.DAO.Contracts;



import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;
import GL.AdisyonSistemi.Models.Entities.Siparis;

import java.util.List;

public interface OdemeDaoInterface {
    void save(Odeme odeme);
    Odeme findById(Integer id);
    void update(Odeme odeme);
    void delete(Integer id);
    List<Odeme> findAll();
    Odeme findByMasaId(Integer masaId);
    Siparis findSiparisByOdemeId(Integer id);
    Masa findMasaByOdemeId(Integer id);
}