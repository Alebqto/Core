package prueba.SpringBoot.todo1.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.SpringBoot.todo1.entity.Product;
import prueba.SpringBoot.todo1.repository.ProductRepository;
import prueba.SpringBoot.todo1.service.ProductService;

/**
 * @author AlejandroDavidSalazar@gmail.com
 *
 */
@Service
public class ProductServiceImpl implements ProductService{

 @Autowired
 private ProductRepository productRepository;

 public void setProductRepository(ProductRepository productRepository) {
  this.productRepository = productRepository;
 }
 
 public List<Product> retrieveProducts() {
  List<Product> products = productRepository.findAll();
  return products;
 }
 
 public Product getProduct(Long productId) {
  Optional<Product> optProd = productRepository.findById(productId);
  return optProd.get();
 }
 
 public void saveProduct(Product product){
	 productRepository.save(product);
 }
 
 public void deleteProduct(Long productId){
	 productRepository.deleteById(productId);
 }
 
 public void updateProduct(Product product) {
	 productRepository.save(product);
 }
 
 public void updateProductExistence(Long id, Integer cant) {
 Product prductToUpdate = productRepository.getOne(id);
 prductToUpdate.setProductQuantity(cant);
 System.out.println(id);
 System.out.println(cant);
 System.out.println(prductToUpdate);
 productRepository.save(prductToUpdate);
 
 }
}