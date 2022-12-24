package e1;

import e1.Productos.Alcachofa;
import e1.Productos.RTX4090;


import java.util.ArrayList;

public class ShoppingSystem {

    int orderIndex = 0;
    public ArrayList<Order> orders = new ArrayList<>();


    public static void main(String[] args) {

        ShoppingSystem shoppingSystem = new ShoppingSystem();
        Order o =  shoppingSystem.NewOrder();

        System.out.print( o.screenInfo() + "\n");


        o.addProduct(RTX4090.getInstancia());
        o.addProduct(Alcachofa.getInstancia());
        System.out.print( o.screenInfo() + "\n");


        o.nextState();//CheckOut

        o.modifyProduct(RTX4090.getInstancia(),2);
        System.out.print( o.screenInfo() + "\n");
        o.removeProduct(RTX4090.getInstancia());

        o.nextState();//Pay

        o.timePassed = 24;

        o.pay();
        System.out.print( o.screenInfo() + "\n");

        o.nextState(); //Completado


        System.out.print( o.screenInfo() + "\n");


        System.out.print("\n ---------------------LOG---------------------\n\n" + o.getLog());




    }
    public Order NewOrder() {

        Order o = new Order(orderIndex);
        orders.add(o);
        orderIndex++;

        o.nextState();

        return o;
    }

    public void CancelOrder(Order o) {

        if(!o.cancel()){

            throw new IllegalStateException();

        }
 
    }

}
