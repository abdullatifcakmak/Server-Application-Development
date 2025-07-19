package GL.AdisyonSistemi.Services.Contracts;



import GL.AdisyonSistemi.Models.Entities.Siparis;

import java.util.List;

public interface SiparisServiceInterface {
    void save(Siparis siparis);
    Siparis findById(Integer id);
    void update(Siparis siparis,int odemeId);
    void delete(Integer id);
    List<Siparis> findAll();
}
