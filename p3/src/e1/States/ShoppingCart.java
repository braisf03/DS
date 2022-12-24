package e1.States;

import e1.Order;
import e1.Productos.Product;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ShoppingCart implements IOrderState {

    private static final ShoppingCart _instancia = new ShoppingCart();
    private ShoppingCart() { }
    public static ShoppingCart getInstancia() { return _instancia; }

    @Override
    public void OnSetState(Order o) {


        o.modifyLog(String.format("Order %d: ShoppingCart Phase",o.getOrderNumber()));

    }

    @Override
    public IOrderState PrevState(Order o) {
        throw  new IllegalStateException();
    }

    @Override
    public IOrderState NextState(Order o) {
        return CheckOut.getInstancia();
    }


    @Override
    public void addProduct(Order order, Product p, HashMap<Product, Integer> productList){

        if(!p.thereIsStock()){

            throw new NoSuchElementException();
        }
        productList.put(p.get(),1);

        IOrderState.super.addProduct(order,p,productList);

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
        throw  new IllegalStateException();

    }

    @Override
    public boolean cancel(Order order) {
        return false;

    }

    @Override
    public String getInfo(Order order) {

        if(order.getNumProducts() == 0){
            return "Phase : Shopping -- Welcome to online shop";

        }
        else {
            return String.format("Phase : Shopping -- %d products",order.getNumProducts());

        }
    }
}
