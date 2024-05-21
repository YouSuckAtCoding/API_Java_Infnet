package infnet.edu.tp2.Repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.edu.tp2.Model.Product;

@Repository
public class ProductRepository {

    private int IdCounter = 1;
    private List<Product> products = new ArrayList<Product>();      

    public List<Product> GetAll()
    {
        return products;
    }   
    public Product Get(int index)
    {
        return products.get(index - 1);
    }   

    public Product Create(Product product)
    {
        Product newProdudct = product;
        newProdudct.setid(IdCounter);
        IdCounter++;
        products.add((newProdudct));
        return newProdudct;
    }

    public Product Update(Product product)
    {
        int index = product.getid() - 1;
        Product old = products.get(index);
            old.setName(product.getName());
            old.setPrice(product.getPrice());
            products.set(index, old);    
            return old;      
    }

    public void Delete(int index)
    {
        products.remove(index - 1);
        IdCounter--;
    }   
}
