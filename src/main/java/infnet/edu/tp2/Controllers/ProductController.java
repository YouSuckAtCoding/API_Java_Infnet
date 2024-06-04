package infnet.edu.tp2.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import infnet.edu.tp2.Model.Product;
import infnet.edu.tp2.Repositories.ProductRepository;

@RestController
public class ProductController {
    

    private ProductRepository _product;
    
    private static final String IdPathVariable = "id";
    private static final String Base = "api/product";
    private static final String GetEndpoint = Base + "{id}";
    private static final String GetAllEndpoint = Base;
    private static final String CreateEndpoint =  Base;
    private static final String UpdateEndpoint = Base + "update";
    private static final String DeleteEndpoint = Base + "{id}";

    public ProductController(ProductRepository product) {
        _product = product;
    }
	
    @GetMapping(GetEndpoint)
    public Product GetProdcts(@PathVariable(IdPathVariable) int id)
    {
        return _product.Get((id));
    }

    @GetMapping(GetAllEndpoint)
    public List<Product> GetProdcts()
    {
        return _product.GetAll();
    }

    @PostMapping(CreateEndpoint)
    public Product CreateProduct(@RequestBody Product product)
    {
        try {
          
            return _product.Create(product);
           
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return new Product();
    }

    @PutMapping(UpdateEndpoint)
    public Product UpdateProduct(@RequestBody Product product)
    {
        try {

            return _product.Update(product);
                
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return new Product();
    }

    @DeleteMapping(DeleteEndpoint)
    @ResponseStatus(code = HttpStatus.OK, reason = "DELETED")
    public void DeleteProduct(@PathVariable(IdPathVariable) int id)
    {
        _product.Delete(id);
    }
}
