package prueba.SpringBoot.todo1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author AlejandroDavidSalazar@gmail.com
 *
 */
@Entity
@Table(name="INVENTORY")
public class Inventory {
 
	public Inventory(){}
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Long id;
 
 @Column(name="INVENTORY_NAME")
 private String name;
 
 @OneToMany(targetEntity=Product.class,mappedBy = "inventory", cascade = CascadeType.ALL)
 @JsonBackReference
 private List<Product> products;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 
 public List<Product> getProducts() {
     return products;
 }

 public void setInventorys(List<Product> products) {
     this.products = products;
 }
 
}
