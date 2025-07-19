package GL.AdisyonSistemi.Services;


import GL.AdisyonSistemi.DAO.Contracts.MasaDaoInterface;
import GL.AdisyonSistemi.DAO.Contracts.OdemeDaoInterface;
import GL.AdisyonSistemi.Exception.BadRequestException;
import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;
import GL.AdisyonSistemi.Models.Entities.Siparis;
import GL.AdisyonSistemi.Services.Contracts.OdemeServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OdemeService implements OdemeServiceInterface {

    private final OdemeDaoInterface odemeDao;
    private final MasaDaoInterface masaDao;

    @Autowired
    public OdemeService(OdemeDaoInterface odemeDao, MasaDaoInterface masaDao) {
        this.odemeDao = odemeDao;
        this.masaDao = masaDao;
    }

    @Transactional
    @Override
    public void save(Odeme odeme) {
        if (odeme.getToplamTutar() < 0){
            throw new BadRequestException("Tutar negatif olamaz!");
        }
        odemeDao.save(odeme);
    }

    @Override
    public Odeme findById(Integer id) {
        return odemeDao.findById(id);
    }

    @Override
    public void update(Odeme odeme) {
        odemeDao.update(odeme);
    }

    @Transactional
    @Override
    public void odemeYap(Odeme odeme) {
        if (odeme.getToplamTutar() < 0){
            throw new BadRequestException("Tutar negatif olamaz!");
        }
        else {
            Masa masa = odeme.getMasa();
            masa.setToplamTutar(0);
            masa.setDurum("boş");
            masaDao.update(masa);
            odemeDao.update(odeme);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        odemeDao.delete(id);
    }

    @Override
    public List<Odeme> findAll() {
        return odemeDao.findAll();
    }

    @Override
    public Siparis findSiparisOdemeId(Integer id) {
        return odemeDao.findSiparisByOdemeId(id);
    }

    @Override
    public Masa findMasaOdemeId(Integer id) {
        return odemeDao.findMasaByOdemeId(id);
    }
}