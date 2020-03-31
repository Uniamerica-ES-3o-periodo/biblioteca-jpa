package dao;

import model.Categoria;
import model.Editora;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CategoriaDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    public CategoriaDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.entityManagerFactory.createEntityManager();
    }

    public void save(Categoria categoria) {
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
    }

    public void update(Categoria categoria) {
        Categoria byId = findById(categoria.getId());
        if (byId != null) {
            em.getTransaction().begin();
            em.merge(categoria);
            em.getTransaction().commit();
        } else {
            System.out.println("Não foi possível achar o categoria passado como parametro");
        }
    }

    public List<Categoria> findAll() {
        return em.createQuery("from Categoria ").getResultList();
    }

    public Categoria findById(Long id) {
        return em.find(Categoria.class, id);
    }

    public void remove(Long id) {
        em.getTransaction().begin();
        Categoria categoria = em.find(Categoria.class, 1L);
        if (categoria != null) {
            em.remove(categoria);
        }
        em.getTransaction().commit();
    }

    public Categoria findByName(String nome) {
        Categoria singleResult = (Categoria) em.createQuery("from Categoria c where c.nome LIKE '%" + nome + "%'").getSingleResult();
        return singleResult;
    }
}
