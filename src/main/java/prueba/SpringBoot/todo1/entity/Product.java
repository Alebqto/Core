package prueba.SpringBoot.todo1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author AlejandroDavidSalazar@gmail.com
 *
 */
@Entity
@Table(name="PRODUCT")
public class Product {
 

 private Long id;
 private String name;
 private TypeProduct typeProduct;
 private Brand brand;
 private Inventory inventory;
 private Long price;
 private Integer quantity;
 public Product(){}
 public Product(String name, TypeProduct typeProduct, Brand brand, Inventory inventory, Long price, Integer quantity){
     this.name = name;  
     this.typeProduct = typeProduct;
     this.brand = brand;
     this.inventory = inventory;
     this.price = price;
     this.quantity = quantity;
 }
 
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }
 
 @Column(name="PRODUCT_NAME")
 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }
 
 @ManyToOne
 @JoinColumn(name = "PRODUCT_TYPE_ID")
 @JsonManagedReference
 public TypeProduct getTypeProduct() {
  return typeProduct;
 }

 public void setTypeProduct(TypeProduct typeProduct) {
  this.typeProduct = typeProduct;
 }
 
 @ManyToOne
 @JoinColumn(name = "BRAND_ID")
 @JsonManagedReference
 public Brand getBrand() {
	  return brand;
	 }

	 public void setBrand(Brand brand) {
	  this.brand = brand;
	 }

	 @ManyToOne
	 @JoinColumn(name = "INVENTORY_ID")
	 @JsonManagedReference
	 public Inventory getInventory() {
		  return inventory;
		 }

		 public void setInventory(Inventory inventory) {
		  this.inventory = inventory;
		 }

		 @Column(name="PRODUCT_PRICE")		 
 public Long getPrice() {
  return price;
 }

 public void setPrice(Long price) {
  this.price = price;
 }
 @Column(name="PRODUCT_QUANTITY")
 public Integer getProductQuantity() {
	  return quantity;
	 }

	 public void setProductQuantity(Integer quantity) {
	  this.quantity = quantity;
	 }
}