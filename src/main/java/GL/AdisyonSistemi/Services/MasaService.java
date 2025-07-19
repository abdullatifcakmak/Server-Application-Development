package GL.AdisyonSistemi.Services;


import GL.AdisyonSistemi.DAO.Contracts.MasaDaoInterface;
import GL.AdisyonSistemi.Exception.ResourceNotFoundException;
import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;
import GL.AdisyonSistemi.Services.Contracts.MasaServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasaService implements MasaServiceInterface {

    private final MasaDaoInterface masaDao;

    @Autowired
    public MasaService(MasaDaoInterface masaDao) {
        this.masaDao = masaDao;
    }

    @Transactional
    @Override
    public void save(Masa masa) {
        masaDao.save(masa);
    }

    @Override
    public Masa findById(Integer id) {
        if (masaDao.findById(id) == null) {
            throw new ResourceNotFoundException("Masa not found");
        }
        else{

            return masaDao.findById(id);
        }

    }

    @Transactional
    @Override
    public void update(Masa masa) {
        masaDao.update(masa);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        masaDao.delete(id);
    }

    @Override
    public List<Masa> findAll() {
        return masaDao.findAll();
    }

    @Override
    public List<Odeme> findOdemeByMasa(Integer masaId) {
        return masaDao.findOdemeByMasa(masaId);
    }

}