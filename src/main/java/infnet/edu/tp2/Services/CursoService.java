package infnet.edu.tp2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import infnet.edu.tp2.Model.Curso;
import infnet.edu.tp2.Repositories.CursoRepository;

@Service
public class CursoService {
private final String cacheName = "cursos";

    @Autowired
    private CursoRepository _curso;

    @Cacheable(value = cacheName)
    public List<Curso> GetAll()
    {
        List<Curso> res = _curso.findAll();
        return res;
    }

    public Curso Get(long id)
    {
        Curso res = _curso.findById(id).get();
        return res;
    }

    @CacheEvict(value = cacheName, allEntries = true)
    public Curso CreateCurso(Curso curso)
    {
        return _curso.saveAndFlush(curso);
    }

    @CacheEvict(value = cacheName, allEntries = true)
    public Curso UpdateCurso(Curso curso)
    {
        Curso current = _curso.findById(curso.getId()).get();
            
            if(curso.getAluno() != null && curso.getAluno() != current.getAluno())
                current.setAluno(curso.getAluno());
            if(curso.getNome() != "" && curso.getNome() != current.getNome())
                current.setNome(curso.getNome());
            if(curso.getDuracao() != current.getDuracao())
                current.setDuracao(curso.getDuracao());

            return _curso.saveAndFlush(current);
    }

    @CacheEvict(value = cacheName, allEntries = true)
    public void DeleteCurso(long id)
    {
        _curso.deleteById(id);
    }
}
