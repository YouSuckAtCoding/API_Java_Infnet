package infnet.edu.tp2.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import infnet.edu.tp2.Model.Curso;
import infnet.edu.tp2.Services.CursoService;

import java.util.List;

@RestController
public class CursoController {

    private static final String Id = "id";
    private static final String Base = "api/curso";
    private static final String GetEndpoint = Base + "{id}";
    private static final String GetAllEndpoint = Base;
    private static final String CreateEndpoint = Base;
    private static final String UpdateEndpoint = Base + "/update";
    private static final String DeleteEndpoint = Base + "{id}";

    private CursoService _curso;


    public CursoController(CursoService cursoService) {
        this._curso = cursoService;
    }

    @GetMapping(GetAllEndpoint)
    public List<Curso> GetAll()
    {
        return _curso.GetAll();
    }

    @GetMapping(GetEndpoint)
    public Curso GetAll(@PathVariable(Id) long id)
    {
        return _curso.Get(id);
    }
    
    @PostMapping(CreateEndpoint)
    public Curso CreateProduct(@RequestBody Curso curso) {
        try {

            return _curso.CreateCurso(curso);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Curso();
    }

    @PutMapping(UpdateEndpoint)
    public Curso UpdateProduct(@RequestBody Curso curso) {
        try {

            return _curso.UpdateCurso(curso);
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Curso();
    }

    @DeleteMapping(DeleteEndpoint)
    @ResponseStatus(code = HttpStatus.OK, reason = "DELETED")
    public void DeleteProduct(@PathVariable(Id) long id) {
    
        _curso.DeleteCurso(id);
    
    }

}
