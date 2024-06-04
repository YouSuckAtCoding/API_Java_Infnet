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

import infnet.edu.tp2.Model.Aluno;
import infnet.edu.tp2.Services.AlunoService;

import java.util.List;



@RestController
public class AlunoController {

    private static final String Id = "id";
    private static final String Base = "api/aluno";
    private static final String GetEndpoint = Base + "/{id}";
    private static final String GetAllEndpoint = Base;
    private static final String CreateEndpoint = Base;
    private static final String UpdateEndpoint = Base + "/update";
    private static final String DeleteEndpoint = Base + "/{id}";

    private AlunoService _Service;

    public AlunoController(AlunoService service) {
        this._Service = service;
    }

    
    @GetMapping(GetAllEndpoint)
    public List<Aluno> GetAll() {
        return _Service.GetAll();
    }

    @GetMapping(GetEndpoint)
    public Aluno GetAll(@PathVariable(Id) long id) {
        return _Service.Get(id);
    }

    @PostMapping(CreateEndpoint)
    public Aluno CreateProduct(@RequestBody Aluno aluno) {
        try {

            return _Service.CreateAluno(aluno);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Aluno();
    }

    @PutMapping(UpdateEndpoint)
    public Aluno UpdateProduct(@RequestBody Aluno aluno) {
        try {

            return _Service.UpdateAluno(aluno);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Aluno();
    }

    @DeleteMapping(DeleteEndpoint)
    @ResponseStatus(code = HttpStatus.OK, reason = "DELETED")
    public void DeleteProduct(@PathVariable(Id) long id) {
        
        _Service.DeleteAluno(id);

    }

}
