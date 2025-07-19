package GL.AdisyonSistemi.DAO.Contracts;



import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;

import java.util.List;

public interface MasaDaoInterface {
    void save(Masa masa);
    Masa findById(Integer id);
    void update(Masa masa);
    void delete(Integer id);
    List<Masa> findAll();
    List<Odeme> findOdemeByMasa(Integer masaId);
}
