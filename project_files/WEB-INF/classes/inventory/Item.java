package inventory;

import java.io.*;

public class Item implements Serializable {
  String name;
  String price;
  String image;
  
  public String toString() {
    return this.name + " $" + this.price; 
  }
  public String getName() {
    return this.name;
  }
  public String getPrice() {
    return this.price;
  }
  public String getImage() {
    return this.image;
  }
}