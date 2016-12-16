package inventory;

import java.io.*;
import java.util.*;

public class OrderManager {
  // run in Tomcat
  final static String ORDERS = "/u/ecrichlo/c212-workspace/apache-tomcat-7.0.35/webapps/shopping-cart/WEB-INF/orders";
  // run in DrJava (windows)
  //final static String ORDERS = "..\\orders";
  
  static int orderNumber = 0;
  public static void main(String[] args) throws IOException {
    initializeOrders();
  }
  
  //public static Map getOrder(Integer orderNumber) {}
  
  public static Integer getNewOrderNumber() {
    return orderNumber += 1;
  }
  
  public static Map getAllOrders() throws IOException, FileNotFoundException, ClassNotFoundException {
    FileInputStream fins = new FileInputStream(ORDERS);
    ObjectInputStream obis = new ObjectInputStream(fins);
    @SuppressWarnings("unchecked") Map<Integer, Map<Item, Integer>> orders = (HashMap<Integer, Map<Item, Integer>>) obis.readObject();
    obis.close();
    return orders;
  }
  
  public static void addOrder(Map<Integer, Map<Item, Integer>> order) throws IOException, ClassNotFoundException {
    //get orders
    @SuppressWarnings("unchecked") Map<Integer, Map<Item, Integer>> allOrders = getAllOrders(); // returns HashMap
    //add new order
    for (Integer lineItem : order.keySet()) {
      allOrders.put(lineItem, order.get(lineItem));
    }
    //output all to orders file
    FileOutputStream fouts = new FileOutputStream(ORDERS);
    ObjectOutputStream obos = new ObjectOutputStream(fouts);
    obos.writeObject(allOrders);
  }
  
  public static void initializeOrders() throws IOException, FileNotFoundException {
    Map<Integer, Map<Item, Integer>> orders = new HashMap<>();
    FileOutputStream fouts = new FileOutputStream(ORDERS);
    ObjectOutputStream obos = new ObjectOutputStream(fouts);
    obos.writeObject(orders);
  }
}