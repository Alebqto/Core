package prueba.SpringBoot.todo1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "prueba.SpringBoot.todo1.repository")
@PropertySource("persistence-product.properties")
@EnableAutoConfiguration
@AutoConfigureTestEntityManager
@EnableTransactionManagement
public class PrdouctJpaConfig {
	
	 
	    @Autowired
	    private Environment env;
	     
	    @Bean
	    public DriverManagerDataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	        dataSource.setUrl(env.getProperty("jdbc.url"));
	        dataSource.setUsername(env.getProperty("jdbc.username"));
	        dataSource.setPassword(env.getProperty("jdbc.password"));
	 
	        return  dataSource;
	    }
	     
	    // configure entityManagerFactory
	     
	    // configure transactionManager
	 
	    // configure additional Hibernate Properties
	
}
