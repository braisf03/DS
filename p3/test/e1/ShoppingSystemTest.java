package e1;

import e1.Productos.Alcachofa;
import e1.Productos.RTX4090;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingSystemTest {


    void RenewStock(){

        RTX4090.getInstancia().renewStockTo(10);
        Alcachofa.getInstancia().renewStockTo(10);


    }

    @Test
    public void TestCompra() {

        RenewStock();
        ShoppingSystem shoppingSystem = new ShoppingSystem();
        Order o = shoppingSystem.NewOrder();

        assertEquals("""
                Order Number : 0
                Phase : Shopping -- Welcome to online shop""", o.screenInfo());


        o.addProduct(RTX4090.getInstancia());
        o.addProduct(Alcachofa.getInstancia());
        assertEquals("""
                Order Number : 0
                Phase : Shopping -- 2 products""", o.screenInfo());

        o.nextState();//CheckOut

        o.modifyProduct(RTX4090.getInstancia(), 2);
        assertEquals("""
                Order Number : 0
                Phase : Chek Out : 2 products""", o.screenInfo());
        o.removeProduct(RTX4090.getInstancia());

        o.nextState();//Pay

        o.timePassed = 24;

        o.pay();
        /*assertEquals("""
                Order Number : 0
                Phase : Paid Order : 1 products -- date 2022/12/07 18:14:56""", o.screenInfo()); // Bueno esto no se puede comprobar por la hora*/

        o.nextState(); //Completado


        assertEquals("""
                Order Number : 0
                Phase : Completed Order : 1 products""", o.screenInfo());

        assertEquals("""
                Order 0: ShoppingCart Phase
                - Add : Item : 129 - Quantity : 1 -> Check Out -- Products : 1
                - Add : Item : 131 - Quantity : 1 -> Check Out -- Products : 2
                Order 0: CheckOut Phase
                - Modify : Item : 129 - Quantity : 2 -> CheckOut Order -- Products : 2
                - Remove : Item : 129 -> Check Out -- Products : 1
                Order 0: Payment Phase
                Order 0: Completed Phase
                """, o.getLog());


    }
    @Test
    public void TestCambioEstados() {

        RenewStock();
        ShoppingSystem shoppingSystem = new ShoppingSystem();
        Order o = shoppingSystem.NewOrder();    //SHoppin Cart

        o.addProduct(RTX4090.getInstancia());
        assertThrows(IllegalStateException.class, o::goBack);
        o.nextState();  //CheckOut
        o.nextState();  //Payment
        assertThrows(IllegalStateException.class, o::goBack);

        assertThrows(IllegalArgumentException.class, o::nextState);

        o.pay();

        o.timePassed = 10;
        assertThrows(IllegalArgumentException.class, o::nextState);
        o.timePassed = 24;

        o.nextState();  //Completed
        assertThrows(IllegalStateException.class, o::goBack);

        assertThrows(IllegalStateException.class, o::nextState);


    }


    @Test
    public void TestAddProduct(){

        RenewStock();

        ShoppingSystem shoppingSystem = new ShoppingSystem();
        Order o = shoppingSystem.NewOrder();    //ShopinggCart

        for (int i = 0; i < 10; i++) {
            o.addProduct (RTX4090.getInstancia());
        }
        assertThrows(NoSuchElementException.class, () ->o.addProduct (RTX4090.getInstancia()));

        o.nextState();  //CheckOut
        assertThrows(IllegalStateException.class, () ->o.addProduct (RTX4090.getInstancia()));
        o.nextState();  //Payment
        assertThrows(IllegalStateException.class, () ->o.addProduct (RTX4090.getInstancia()));
        o.timePassed = 24;
        o.pay();
        o.nextState();  //Completed
        assertThrows(IllegalStateException.class, () ->o.addProduct (RTX4090.getInstancia()));

    }
    @Test
    public void TestRemoveProduct(){

        RenewStock();

        ShoppingSystem shoppingSystem = new ShoppingSystem();
        Order o = shoppingSystem.NewOrder();    //ShopinggCart

        o.addProduct (RTX4090.getInstancia());

        assertThrows(IllegalStateException.class, () ->o.removeProduct (RTX4090.getInstancia()));

        o.nextState();  //CheckOut
        assertThrows(NoSuchElementException.class, () ->o.removeProduct (Alcachofa.getInstancia()));
        o.nextState();  //Payment
        assertThrows(IllegalStateException.class, () ->o.removeProduct (RTX4090.getInstancia()));
        o.timePassed = 24;
        o.pay();
        o.nextState();  //Completed
        assertThrows(IllegalStateException.class, () ->o.removeProduct (RTX4090.getInstancia()));

    }
    @Test
    public void TestModifyProduct(){

        RenewStock();

        ShoppingSystem shoppingSystem = new ShoppingSystem();
        Order o = shoppingSystem.NewOrder();    //ShopinggCart

        o.addProduct (RTX4090.getInstancia());

        assertThrows(IllegalStateException.class, () ->o.modifyProduct (RTX4090.getInstancia(),1));

        o.nextState();  //CheckOut

        assertThrows(IllegalArgumentException.class, () ->o.modifyProduct (Alcachofa.getInstancia(),10));

        assertThrows(IllegalArgumentException.class, () ->o.modifyProduct (RTX4090.getInstancia(),11));
        assertThrows(IllegalArgumentException.class, () ->o.modifyProduct (RTX4090.getInstancia(),-1));

        o.nextState();  //Payment
        assertThrows(IllegalStateException.class, () ->o.modifyProduct (RTX4090.getInstancia(),1));
        o.timePassed = 24;
        o.pay();
        o.nextState();  //Completed
        assertThrows(IllegalStateException.class, () ->o.modifyProduct (RTX4090.getInstancia(),1));

    }
    @Test
    public  void TestPay(){

        RenewStock();

        ShoppingSystem shoppingSystem = new ShoppingSystem();
        Order o = shoppingSystem.NewOrder();    //ShopinggCart


        assertThrows(IllegalStateException.class,o::pay);

        o.nextState();  //CheckOut

        assertThrows(IllegalStateException.class,o::pay);


        o.nextState();  //Payment

        assertThrows(IllegalArgumentException.class,o::pay);

        //--------------------------------------------------------------

        RenewStock();
        o = shoppingSystem.NewOrder();    //ShopinggCart

        o.addProduct (RTX4090.getInstancia());

        assertThrows(IllegalStateException.class,o::pay);

        o.nextState();  //CheckOut

        assertThrows(IllegalStateException.class,o::pay);


        o.nextState();  //Payment

        o.pay();
        assertThrows(IllegalArgumentException.class,o::pay);

        o.timePassed = 24;
        o.nextState();  //Completed
        assertThrows(IllegalArgumentException.class,o::pay);


    }
    @Test
    public  void TestCancel(){

        ShoppingSystem shoppingSystem = new ShoppingSystem();
        Order o = shoppingSystem.NewOrder();    //ShopinggCart

        assertThrows(IllegalStateException.class,() -> shoppingSystem.CancelOrder(o));

        o.addProduct(RTX4090.getInstancia());
        o.nextState();  //CheckOut
        assertThrows(IllegalStateException.class,() -> shoppingSystem.CancelOrder(o));

        o.nextState();  //Payment
        assertThrows(IllegalStateException.class,() -> shoppingSystem.CancelOrder(o));

        o.pay();
        o.timePassed = 24;
        assertThrows(IllegalStateException.class,() -> shoppingSystem.CancelOrder(o));


        //----------------------------------------------------------------


         Order o2 = shoppingSystem.NewOrder();    //ShopinggCart

        assertThrows(IllegalStateException.class,() -> shoppingSystem.CancelOrder(o2));

        o2.addProduct(RTX4090.getInstancia());
        o2.nextState();  //CheckOut
        assertThrows(IllegalStateException.class,() -> shoppingSystem.CancelOrder(o2));

        o2.nextState();  //Payment
        assertThrows(IllegalStateException.class,() -> shoppingSystem.CancelOrder(o2));


        o2.timePassed = 10;
        o2.pay();
        o2.cancel();

        assertThrows(IllegalStateException.class,() -> shoppingSystem.CancelOrder(o2));


    }
}