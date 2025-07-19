package GL.AdisyonSistemi.DAO.Contracts;



import GL.AdisyonSistemi.Models.Entities.Siparis;

import java.util.List;

public interface SiparisDaoInterface {
    void save(Siparis siparis);
    Siparis findById(Integer id);
    void update(Siparis siparis);
    void delete(Integer id);
    List<Siparis> findAll();
}
