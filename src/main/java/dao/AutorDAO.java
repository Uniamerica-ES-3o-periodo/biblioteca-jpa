package dao;

import model.Autor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AutorDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    public AutorDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.entityManagerFactory.createEntityManager();
    }

    public void save(Autor autor) {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public void update(Autor autor) {
        Autor byId = findById(autor.getId());
        if (byId != null) {
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
        } else {
            System.out.println("Não foi possível achar o autor passado como parametro");
        }
    }

    public List<Autor> findAll() {
        return em.createQuery("from Autor ").getResultList();
    }

    public Autor findById(Long id) {
        return em.find(Autor.class, id);
    }

    public void remove(Long id) {
        em.getTransaction().begin();
        Autor autor = em.find(Autor.class, 1L);
        if (autor != null) {
            em.remove(autor);
        }
        em.getTransaction().commit();
    }
}
