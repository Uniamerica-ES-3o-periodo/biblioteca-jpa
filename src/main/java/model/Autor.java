package model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String nomeCatalogo;

    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCatalogo() {
        String[] s = this.nome.split(" ");
        return this.nome.split(" ")[s.length - 1].toUpperCase() + ", " + String.join(" ", Arrays.copyOf(s, s.length-1));
    }

    public void setNomeCatalogo() {
        this.nomeCatalogo = getNomeCatalogo();
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeCatalogo='" + nomeCatalogo + '\'' +
                '}';
    }
}
