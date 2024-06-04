package infnet.edu.tp2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import infnet.edu.tp2.Model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
