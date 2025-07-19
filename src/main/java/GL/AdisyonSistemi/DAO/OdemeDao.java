package GL.AdisyonSistemi.DAO;



import GL.AdisyonSistemi.DAO.Contracts.OdemeDaoInterface;
import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;
import GL.AdisyonSistemi.Models.Entities.Siparis;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OdemeDao implements OdemeDaoInterface {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Odeme odeme) {
        entityManager.persist(odeme);
    }

    @Override
    public Odeme findById(Integer id) {
        return entityManager.find(Odeme.class, id);
    }


    @Override
    public void update(Odeme odeme) {
        entityManager.merge(odeme);
    }


    @Override
    public void delete(Integer id) {
        Odeme odeme = findById(id);
        if (odeme != null) {
            entityManager.remove(odeme);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Odeme> findAll() {
        return entityManager.createQuery("SELECT o FROM Odeme o",Odeme.class).getResultList();
    }

    @Override
    public Odeme findByMasaId(Integer masaId) {
        TypedQuery<Odeme> query = entityManager.createQuery(
                "SELECT o FROM Odeme o WHERE o.masa.id = :masaId", Odeme.class);
        query.setParameter("masaId", masaId);
        return query.getSingleResult();
    }

    @Override
    public Siparis findSiparisByOdemeId(Integer id) {

        Odeme odeme = entityManager.find(Odeme.class, id);
        return odeme.getSiparis();

    }

    @Override
    public Masa findMasaByOdemeId(Integer id) {
        Odeme odeme = entityManager.find(Odeme.class, id);
        return odeme.getMasa();
    }


}