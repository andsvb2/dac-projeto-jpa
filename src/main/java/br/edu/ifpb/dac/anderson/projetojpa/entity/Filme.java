package br.edu.ifpb.dac.anderson.projetojpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "diretor")
    private String diretor;

    @Column(name = "genero")
    private String genero;

    public Filme(){}

    public Filme(String titulo) {
        this.titulo = titulo;
    }

    public Filme(String titulo, String diretor) {
        this.titulo = titulo;
        this.diretor = diretor;
    }

    public Filme(String titulo, String diretor, String genero) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.genero = genero;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Filme filme = (Filme) o;
        return getId() != null && Objects.equals(getId(), filme.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "Título = " + titulo + ", " +
                "Diretor(a) = " + diretor + ", " +
                "Gênero = " + genero + ")";
    }
}