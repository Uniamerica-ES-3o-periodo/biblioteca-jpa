package dao;

import model.Editora;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EditoraDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    public EditoraDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.entityManagerFactory.createEntityManager();
    }

    public void save(Editora editora) {
        em.getTransaction().begin();
        em.persist(editora);
        em.getTransaction().commit();
    }

    public void update(Editora editora) {
        Editora byId = findById(editora.getId());
        if (byId != null) {
            em.getTransaction().begin();
            em.merge(editora);
            em.getTransaction().commit();
        } else {
            System.out.println("Não foi possível achar o editora passado como parametro");
        }
    }

    public List<Editora> findAll() {
        return em.createQuery("from Editora ").getResultList();
    }

    public Editora findById(Long id) {
        return em.find(Editora.class, id);
    }

    public void remove(Long id) {
        em.getTransaction().begin();
        Editora editora = em.find(Editora.class, 1L);
        if (editora != null) {
            em.remove(editora);
        }
        em.getTransaction().commit();
    }

    public Editora findByName(String nome) {
        return (Editora) em.createQuery("from Editora e where e.nome LIKE '%" + nome + "%'").getSingleResult();
    }
}
