package GL.AdisyonSistemi.Services;


import GL.AdisyonSistemi.DAO.Contracts.MasaDaoInterface;
import GL.AdisyonSistemi.DAO.Contracts.OdemeDaoInterface;
import GL.AdisyonSistemi.DAO.Contracts.SiparisDaoInterface;
import GL.AdisyonSistemi.Exception.BadRequestException;
import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;
import GL.AdisyonSistemi.Models.Entities.Siparis;
import GL.AdisyonSistemi.Services.Contracts.SiparisServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiparisService implements SiparisServiceInterface {

    private final SiparisDaoInterface siparisDao;
    private final OdemeDaoInterface odemeDao;
    private final MasaDaoInterface masaDao;

    @Autowired
    public SiparisService(SiparisDaoInterface siparisDao, OdemeDaoInterface odemeDao, MasaDaoInterface masaDao) {
        this.siparisDao = siparisDao;
        this.odemeDao = odemeDao;
        this.masaDao = masaDao;
    }

    @Transactional
    @Override
    public void save(Siparis siparis) {
        Masa masa=masaDao.findById(siparis.getMasaId());
        if(masa.getDurum().equals("boş")){
            Odeme yeniOdeme=new Odeme();
            masa.setToplamTutar((int) (masa.getToplamTutar()+ siparis.getToplamFiyat()));
            masa.setDurum("dolu");
            yeniOdeme.setMasa(masa);
            yeniOdeme.setToplamTutar(masa.getToplamTutar());
            yeniOdeme.setOdemeSekli("nakit");
            yeniOdeme.setOdemeTarihi(null);
            yeniOdeme.setStatus(0);
            masaDao.update(masa);
            odemeDao.save(yeniOdeme);
            siparisDao.save(siparis);
        }
        else
            throw new BadRequestException("ilgili masa dolu");
    }

    @Override
    public Siparis findById(Integer id) {
        return siparisDao.findById(id);
    }

    @Transactional
    @Override
    public void update(Siparis siparis,int odemeId) {
        Masa masa=masaDao.findById(siparis.getMasaId());
        if(masa.getDurum().equals("dolu")){
            Odeme yeniOdeme=odemeDao.findById(odemeId);
            masa.setToplamTutar((int) (masa.getToplamTutar()+ siparis.getToplamFiyat()));
            yeniOdeme.setToplamTutar(masa.getToplamTutar());
            masa.setDurum("dolu");
            masaDao.update(masa);
            odemeDao.update(yeniOdeme);
            siparisDao.update(siparis);
        }
        else
            throw new BadRequestException("ilgili masa boş");
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        siparisDao.delete(id);
    }

    @Override
    public List<Siparis> findAll() {
        return siparisDao.findAll();
    }
}
