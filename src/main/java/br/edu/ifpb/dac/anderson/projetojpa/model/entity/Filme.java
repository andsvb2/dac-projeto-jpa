package br.edu.ifpb.dac.anderson.projetojpa.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "genero")
    private String genero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;

    @Column(name = "ano")
    private Year ano;

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return "Título = '" + titulo + '\'' +
                ", Gênero = '" + genero + '\'' +
                ", Diretor(a) = " + diretor.getNome() +
                ", Ano = " + ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filme filme)) return false;

        if (!titulo.equals(filme.titulo)) return false;
        if (!genero.equals(filme.genero)) return false;
        if (!Objects.equals(diretor, filme.diretor)) return false;
        return ano.equals(filme.ano);
    }

    @Override
    public int hashCode() {
        int result = titulo.hashCode();
        result = 31 * result + genero.hashCode();
        result = 31 * result + (diretor != null ? diretor.hashCode() : 0);
        result = 31 * result + ano.hashCode();
        return result;
    }

}