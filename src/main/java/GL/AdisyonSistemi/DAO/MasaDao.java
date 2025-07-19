package GL.AdisyonSistemi.DAO;


import GL.AdisyonSistemi.DAO.Contracts.MasaDaoInterface;
import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MasaDao implements MasaDaoInterface {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Masa masa) {
        entityManager.persist(masa);
    }

    @Override
    public Masa findById(Integer id) {
        return entityManager.find(Masa.class, id);
    }


    @Override
    public void update(Masa masa) {
        entityManager.merge(masa);
    }


    @Override
    public void delete(Integer id) {
        Masa masa = findById(id);
        if (masa != null) {
            entityManager.remove(masa);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Masa> findAll() {
        return entityManager.createQuery("SELECT m FROM Masa m",Masa.class).getResultList();
    }

    @Override
    public List<Odeme> findOdemeByMasa(Integer masaId) {
        Masa masa = entityManager.find(Masa.class, masaId);
        return masa.getOdemeler();

    }
}
