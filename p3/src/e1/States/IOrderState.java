package e1.States;

import e1.Order;
import e1.Productos.Product;

import java.util.HashMap;

public interface IOrderState {


    void OnSetState(Order o);

    IOrderState PrevState(Order o);
    IOrderState NextState(Order o);
    default void addProduct(Order order, Product p, HashMap<Product, Integer> productList){

        order.modifyLog(String.format("- Add : Item : %d - Quantity : %d -> Check Out -- Products : %d",p.getproID(),productList.get(p),productList.size()));

    }
    default void removeProduct(Order order, Product p, HashMap<Product, Integer> productList){

        order.modifyLog(String.format("- Remove : Item : %d -> Check Out -- Products : %d",p.getproID(),productList.size()));
    }
    void modifyProduct(Order order, Product p, int quantity, HashMap<Product, Integer> productList);

    void pay(Order order);
    boolean cancel(Order order);
    String getInfo(Order order);

}
