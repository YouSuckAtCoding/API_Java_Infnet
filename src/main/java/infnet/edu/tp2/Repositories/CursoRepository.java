package infnet.edu.tp2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import infnet.edu.tp2.Model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
