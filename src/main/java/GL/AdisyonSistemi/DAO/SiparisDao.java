package GL.AdisyonSistemi.DAO;


import GL.AdisyonSistemi.DAO.Contracts.SiparisDaoInterface;
import GL.AdisyonSistemi.Models.Entities.Siparis;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SiparisDao implements SiparisDaoInterface {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Siparis siparis) {
        entityManager.persist(siparis);
    }

    @Override
    public Siparis findById(Integer id) {
        return entityManager.find(Siparis.class, id);
    }


    @Override
    public void update(Siparis siparis) {
        entityManager.merge(siparis);
    }


    @Override
    public void delete(Integer id) {
        Siparis siparis = findById(id);
        if (siparis != null) {
            entityManager.remove(siparis);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Siparis> findAll() {
        return entityManager.createQuery("SELECT s FROM Siparis s",Siparis.class).getResultList();
    }
}