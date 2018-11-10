package prueba.SpringBoot.todo1.service;

import java.util.List;

import prueba.SpringBoot.todo1.entity.Product;

/**
 * @author AlejandroDavidSalazar@gmail.com
 *
 */
public interface ProductService {
 public List<Product> retrieveProducts();
 
 public Product getProduct(Long productId);
 
 public void saveProduct(Product product);
 
 public void deleteProduct(Long productId);
 
 public void updateProduct(Product product);
 
 public void updateProductExistence(Long id, Integer cant);
}
