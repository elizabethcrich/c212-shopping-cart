package inventory;

import java.io.*;

public class Item implements Serializable {
  Integer sku;
  String name;
  Double price;
  String image;
  
  public Item() {}
  public Item(String name, Double price, String image) {
    //this.sku = getSku(); //need method to generate new sku #
    this.name = name;
    this.price = price;
    this.image = image;
  }
  public String toString() {
    return this.name + " $" + this.price; 
  }
  public String getName() {
    return this.name;
  }
  public Double getPrice() {
    return this.price;
  }
  public String getImage() {
    return this.image;
  }
}