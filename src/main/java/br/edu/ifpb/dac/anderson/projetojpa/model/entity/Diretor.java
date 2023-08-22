package br.edu.ifpb.dac.anderson.projetojpa.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "diretor")
public class Diretor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "diretor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Filme> filmes = new LinkedHashSet<>();

    @Column(name = "nome")
    private String nome;

    @Column(name = "pais")
    private String pais;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public void addFilme(Filme filme) {
        filmes.add(filme);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Diretor diretor = (Diretor) o;
        return getId() != null && Objects.equals(getId(), diretor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Nome = '" + nome + '\'' +
                ", País = '" + pais + '\'' +
                ", Data de Nascimento = " + dataNascimento;
    }


}