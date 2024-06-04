package infnet.edu.tp2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import infnet.edu.tp2.Model.Aluno;
import infnet.edu.tp2.Repositories.AlunoRepository;


@Service
public class AlunoService {

    private final String cacheName = "alunos";

    @Autowired
    private AlunoRepository _aluno;

    @Cacheable(value = cacheName)
    public List<Aluno> GetAll()
    {
        List<Aluno> res = _aluno.findAll();
        return res;
    }

    public Aluno Get(long id)
    {
        Aluno res = _aluno.findById(id).get();
        return res;
    }

    @CacheEvict(value = cacheName, allEntries = true)
    public Aluno CreateAluno(Aluno aluno)
    {
        return _aluno.saveAndFlush(aluno);
    }

    @CacheEvict(value = cacheName, allEntries = true)
    public Aluno UpdateAluno(Aluno aluno)
    {
        Aluno current = _aluno.findById(aluno.getId()).get();
            
            if(aluno.getIdade() > 0 && aluno.getIdade() != current.getIdade())
                current.setIdade(aluno.getIdade());
            if(aluno.getName() != "" && aluno.getName() != current.getName())
                current.setName(aluno.getName());
            if(aluno.isSexo() != current.isSexo())
                current.setSexo(aluno.isSexo());

            return _aluno.saveAndFlush(current);
    }

    @CacheEvict(value = cacheName, allEntries = true)
    public void DeleteAluno(long id)
    {
        _aluno.deleteById(id);
    }
}
