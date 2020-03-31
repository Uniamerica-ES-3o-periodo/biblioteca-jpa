import dao.AutorDAO;
import dao.CategoriaDAO;
import dao.EditoraDAO;
import dao.LivroDAO;
import model.Autor;
import model.Categoria;
import model.Editora;
import model.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    public static void main(String[] args) {
        inserirUmNovo();
        inserirMuitosAutoresNovo();
        inserirEditoraExistente();
        LivroDAO livroDAO = new LivroDAO();
        List<Livro> livroList = livroDAO.findByCategory("Comedia");
        for (Livro livo: livroList) {
            System.out.println(livo.toString());
        }

        /*
        * Exemplo de uso de lambda Java 8
        * */
//        livroList.forEach(livro -> System.out.println(livro.toString()));
    }

    private static void inserirEditoraExistente() {
        AutorDAO autorDAO = new AutorDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        EditoraDAO editoraDAO = new EditoraDAO();
        LivroDAO livroDAO = new LivroDAO();

        Autor autor = new Autor();
        Livro livro = new Livro();
        Categoria categoriaNova = new Categoria();

        Editora pearson = editoraDAO.findByName("Pearson");

        autor.setNome("Donato Robinson");
        autor.setNomeCatalogo();

        autorDAO.save(autor);

        Categoria comedia = categoriaDAO.findByName("Comedia");

        categoriaNova.setCodigo("AVN");
        categoriaNova.setNome("Aventura");

        categoriaDAO.save(categoriaNova);

        livro.setAno(LocalDate.now());
        livro.setEdicao("2ª");
        livro.setTitulo("Rir e Fazer Rir");
        livro.setSubtitulo("Uma Abordagem Jurídica dos Limites do Humor");
        livro.setIsbn("85-359-0277-5");
        livro.setEditora(pearson);

        List<Autor> autoresLivro = new ArrayList<>();
        autoresLivro.add(autor);

        List<Categoria> categoriasLivro = new ArrayList<>();
        categoriasLivro.add(comedia);
        categoriasLivro.add(categoriaNova);

        livro.setCategorias(categoriasLivro);
        livro.setAutores(autoresLivro);

        livroDAO.save(livro);
    }

    private static void inserirMuitosAutoresNovo() {
        AutorDAO autorDAO = new AutorDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        EditoraDAO editoraDAO = new EditoraDAO();
        LivroDAO livroDAO = new LivroDAO();

        Editora editora = new Editora();
        Autor autor1 = new Autor();
        Autor autor2 = new Autor();
        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        Livro livro = new Livro();

        editora.setNome("Pearson");
        editora.setEmail("contact@pearson.com");
        editora.setTelefone("(45) 99990-9090");

        editoraDAO.save(editora);

        autor1.setNome("Ennis Robinson");
        autor1.setNomeCatalogo();

        autorDAO.save(autor1);

        autor2.setNome("Narciso Robinson");
        autor2.setNomeCatalogo();

        autorDAO.save(autor2);

        categoria1.setCodigo("DRM");
        categoria1.setNome("Drama");

        categoriaDAO.save(categoria1);

        categoria2.setCodigo("ROM");
        categoria2.setNome("Romance");

        categoriaDAO.save(categoria2);

        livro.setAno(LocalDate.now());
        livro.setEdicao("1ª");
        livro.setTitulo("Hibernate em 2 dias");
        livro.setSubtitulo("Os segredos do hibernate");
        livro.setIsbn("85-359-0277-5");
        livro.setEditora(editora);

        List<Autor> autoresLivro = new ArrayList<>();
        autoresLivro.add(autor1);
        autoresLivro.add(autor2);

        List<Categoria> categoriasLivro = new ArrayList<>();
        categoriasLivro.add(categoria1);
        categoriasLivro.add(categoria2);

        livro.setCategorias(categoriasLivro);
        livro.setAutores(autoresLivro);

        livroDAO.save(livro);
    }

    private static void inserirUmNovo() {
        AutorDAO autorDAO = new AutorDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        EditoraDAO editoraDAO = new EditoraDAO();
        LivroDAO livroDAO = new LivroDAO();

        Editora editora = new Editora();
        Autor autor = new Autor();
        Categoria categoria = new Categoria();
        Livro livro = new Livro();

        editora.setNome("Uniamerica");
        editora.setEmail("editora@uniamerica.br");
        editora.setTelefone("(45) 99990-9090");

        editoraDAO.save(editora);

        autor.setNome("Frederick Nazario Moschkowich");
        autor.setNomeCatalogo();

        autorDAO.save(autor);

        categoria.setCodigo("COM");
        categoria.setNome("Comedia");

        categoriaDAO.save(categoria);

        livro.setAno(LocalDate.now());
        livro.setEdicao("2ª");
        livro.setTitulo("Java para Iniciantes");
        livro.setSubtitulo("Descubra de modo fácil como programar em Java");
        livro.setIsbn("85-359-0277-5");
        livro.setEditora(editora);

        List<Autor> autoresLivro = new ArrayList<>();
        autoresLivro.add(autor);

        List<Categoria> categoriasLivro = new ArrayList<>();
        categoriasLivro.add(categoria);

        livro.setCategorias(categoriasLivro);
        livro.setAutores(autoresLivro);

        livroDAO.save(livro);
    }
}
