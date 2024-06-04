package infnet.edu.tp2.Model;

public class MaterialDidatico {

    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private int numero_pag;
    public int getNumero_pag() {
        return numero_pag;
    }
    public void setNumero_pag(int numero_pag) {
        this.numero_pag = numero_pag;
    }
    
    private Curso curso;
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
