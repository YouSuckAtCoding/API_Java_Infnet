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

    public ProductController(ProductRepository product) {
        _product = product;
    }
	
    @GetMapping("api/product/{id}")
    public Product GetProdcts(@PathVariable("id") int id)
    {
        return _product.Get((id));
    }

    @GetMapping("api/product")
    public List<Product> GetProdcts()
    {
        return _product.GetAll();
    }

    @PostMapping("api/product")
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

    @PutMapping("api/product/update")
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

    @DeleteMapping("api/product/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "DELETED")
    public void DeleteProduct(@PathVariable("id") int id)
    {
        _product.Delete(id);
    }
}
