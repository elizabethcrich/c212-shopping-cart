package inventory;

import java.io.*;

public class Item implements Serializable {
  int sku;
  String name;
  double price;
  String image;
  
  public Item() {}
  public Item(int sku, String name, double price, String image) {
    this.sku = sku;
    this.name = name;
    this.price = price;
    this.image = image;
  }
  public String toString() {
    return this.name + " $" + String.format("%.2f", this.price); 
  }
  public int getSku() {
    return this.sku;
  }
  public String getName() {
    return this.name;
  }
  public String getPrice() {
    return String.format("%.2f", this.price);
  }
  public String getImage() {
    return this.image;
  }
}