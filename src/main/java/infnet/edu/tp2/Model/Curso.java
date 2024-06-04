package infnet.edu.tp2.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    
    @ManyToOne
    private Aluno aluno;
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Column(nullable = false)
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(nullable = false)
    private int duracao;
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

}
