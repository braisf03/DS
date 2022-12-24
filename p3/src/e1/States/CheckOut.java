package e1.States;

import e1.Order;
import e1.Productos.Product;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class CheckOut implements IOrderState {

    private static final CheckOut _instancia = new CheckOut();
    private CheckOut() { }
    public static CheckOut getInstancia() { return _instancia; }



    @Override
    public void OnSetState(Order o) {


        o.modifyLog(String.format("Order %d: CheckOut Phase",o.getOrderNumber()));
    }

    @Override
    public IOrderState PrevState(Order o) {
        return ShoppingCart.getInstancia();
    }

    @Override
    public IOrderState NextState(Order o) {
        return Payment.getInstancia();
    }


    @Override
    public void addProduct(Order order, Product p, HashMap<Product, Integer> productList){
        throw  new IllegalStateException();


    }

    @Override
    public void removeProduct(Order order, Product p, HashMap<Product, Integer> productList){


        if(!productList.containsKey(p)){
            throw new NoSuchElementException();

        }
        p.set();
        productList.remove(p);
        IOrderState.super.removeProduct(order,p,productList);


    }

    @Override
    public void modifyProduct(Order order, Product p, int quantity, HashMap<Product, Integer> productList){

        if(quantity < 0 || quantity > p.getStock() ||!productList.containsKey(p) ){

            throw new IllegalArgumentException();

        }
        int val = productList.get(p);
        productList.replace(p,val+1);

        order.modifyLog(String.format("- Modify : Item : %d - Quantity : %d -> CheckOut Order -- Products : %d",p.getproID(),productList.get(p),productList.size()));

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
        return String.format("Phase : Chek Out : %d products",order.getNumProducts());
    }
}
