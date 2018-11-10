package prueba.SpringBoot.todo1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import prueba.SpringBoot.todo1.entity.Product;
import prueba.SpringBoot.todo1.service.ProductService;

/**
 * @author AlejandroDavidSalazar@gmail.com
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ProductRestController {
 
 @Autowired
 private ProductService productService;
 
 public void setProductService(ProductService productService) {
  this.productService = productService;
 }

 @GetMapping("/api/products")
 public List<Product> getProducts() {
  List<Product> products = productService.retrieveProducts();
  return products;
 }
 
 @GetMapping("/api/products/{productId}")
 public Product getProduct(@PathVariable(name="productId")Long productId) {
  return productService.getProduct(productId);
 }
 
 @PostMapping("/api/products")
 public void saveProduct(Product product){
  productService.saveProduct(product);
  System.out.println("product Saved Successfully");
 }
 
 @DeleteMapping("/api/products/{productId}")
 public void deleteProduct(@PathVariable(name="productId")Long productId){
  productService.deleteProduct(productId);
  System.out.println("Employee Deleted Successfully");
 }
 
 @PutMapping("/api/products/{productId}")
 public void updateProduct(@RequestBody Product product,
   @PathVariable(name="productId")Long productId){
	 Product pro = productService.getProduct(productId);
  if(pro != null){
   productService.updateProduct(product);
  }
  
 }
 
 @PostMapping("/api/updateExistenceProduct/{productId}/{productQuantity}" )
 public void updateExistenceProduct(@PathVariable(name="productId")Long productId,@PathVariable(name="productQuantity")Integer productQuantity){
	 System.out.println("PASOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO================================================================");
	 System.out.println("PASOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO================================================================" + productId);
	 System.out.println("PASOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO================================================================" + productQuantity);
  productService.updateProductExistence(productId,productQuantity);
  System.out.println("Employee Saved Successfully");
 }

}
