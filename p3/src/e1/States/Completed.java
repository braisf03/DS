package e1.States;

import e1.Order;
import e1.Productos.Product;

import java.util.HashMap;

public class Completed implements IOrderState {

    private static final Completed _instancia = new Completed();
    private Completed() { }
    public static Completed getInstancia() { return _instancia; }



    @Override
    public void OnSetState(Order o) {

        o.modifyLog(String.format("Order %d: Completed Phase",o.getOrderNumber()));


    }

    @Override
    public IOrderState PrevState(Order o) {
        throw new IllegalStateException();

    }

    @Override
    public IOrderState NextState(Order o) {
        throw new IllegalStateException();

    }


    @Override
    public void addProduct(Order order, Product p, HashMap<Product, Integer> productList){
        throw  new IllegalStateException();

    }

    @Override
    public void removeProduct(Order order, Product p, HashMap<Product, Integer> productList){
        throw  new IllegalStateException();

    }

    @Override
    public void modifyProduct(Order order, Product p, int quantity, HashMap<Product, Integer> productList){
        throw  new IllegalStateException();

    }



    @Override
    public void pay(Order order) {
        throw  new IllegalStateException(); //Aqui no deberia llegar nunca de todas formas

    }

    @Override
    public boolean cancel(Order order) {
        return false;

    }

    @Override
    public String getInfo(Order order) {
        return String.format("Phase : Completed Order : %d products",order.getNumProducts());
    }
}
