package dao;

import model.Livro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LivroDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    public LivroDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.entityManagerFactory.createEntityManager();
    }

    public void save(Livro livro) {
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();
    }

    public void update(Livro livro) {
        Livro byId = findById(livro.getId());
        if (byId != null) {
            em.getTransaction().begin();
            em.merge(livro);
            em.getTransaction().commit();
        } else {
            System.out.println("Não foi possível achar o livro passado como parametro");
        }
    }

    public List<Livro> findAll() {
        return em.createQuery("from Livro ").getResultList();
    }

    public Livro findById(Long id) {
        return em.find(Livro.class, id);
    }

    public void remove(Long id) {
        em.getTransaction().begin();
        Livro livro = em.find(Livro.class, 1L);
        if (livro != null) {
            em.remove(livro);
        }
        em.getTransaction().commit();
    }

    public List<Livro> findByCategory(String nomeCategoria) {
        return em.createQuery(
                "SELECT DISTINCT l FROM Livro l " +
                "INNER JOIN l.categorias c" +
                " where c.nome = '" + nomeCategoria + "'")
                .getResultList();
    }
}
