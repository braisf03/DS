package e1.States;

import e1.Order;
import e1.Productos.Product;

import java.util.HashMap;

public class Payment implements IOrderState {

    private static final Payment _instancia = new Payment();
    private Payment() { }
    public static Payment getInstancia() { return _instancia; }




    @Override
    public void OnSetState(Order o) {


        o.modifyLog(String.format("Order %d: Payment Phase",o.getOrderNumber()));

    }

    @Override
    public IOrderState PrevState(Order o) {
        throw new IllegalStateException();

    }

    @Override
    public IOrderState NextState(Order o) {

        if(!o.isPaid()  || o.timePassed < 24 ){

            throw new IllegalArgumentException();
        }
        return Completed.getInstancia();
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

        if(order.getNumProducts() == 0){
            throw  new IllegalArgumentException();
        }
        order.setPaid();
    }

    @Override
    public boolean cancel(Order order) {

        return order.isPaid() && order.timePassed < 24;
    }

    @Override
    public String getInfo(Order order) {


        return String.format("Phase : Paid Order : %d products -- date %s",order.getNumProducts(),order.getPaidDate());
    }
}
