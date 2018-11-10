package prueba.SpringBoot.todo1;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import prueba.SpringBoot.todo1.entity.Brand;
import prueba.SpringBoot.todo1.entity.Inventory;
import prueba.SpringBoot.todo1.entity.Product;
import prueba.SpringBoot.todo1.entity.TypeProduct;
import prueba.SpringBoot.todo1.repository.ProductRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(
		  classes = { PrdouctJpaConfig.class }, 
		  loader = AnnotationConfigContextLoader.class)
		@Transactional
public class Todo1ApplicationTests {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ProductRepository productRepository;
    

	@Test
	public void whenFindById_thenReturnProduct() {
	    // given
		TypeProduct typeProduct = new TypeProduct();
		typeProduct.setId((long) 1);
		typeProduct.setName("vaso");
		Brand brand = new Brand();
		brand.setId((long) 1);
		brand.setName("Marvel");
		Inventory inventory = new Inventory();
		inventory.setId((long) 1);
		inventory.setName("Inventario 2018");
	    Product product = new Product("Vaso contigo", typeProduct, brand, inventory, (long)20, 30);
	    entityManager.persist(product);
	    entityManager.flush();
	 
	    // when
	   Optional<Product> found = productRepository.findById((long) 1) ;
	 
	   System.out.println("producto encontrado con el nombre:" +found.get().getName());
	    
	    
	}

}
