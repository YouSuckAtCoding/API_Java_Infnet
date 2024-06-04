package infnet.edu.tp2.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(nullable = false, length = 100)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(nullable = false)
    private int idade;
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
  
    @Column(nullable = false)
    private boolean sexo;
    public boolean isSexo() {
        return sexo;
    }
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
    


}
