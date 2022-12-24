package e1;

import e1.Productos.Product;
import e1.States.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Order {

    private final int _orderNumber;
    private IOrderState _state = null;
    private String _log = "";
    private boolean _paid;
    private String _paidDate;

    public int timePassed = 0;


    private HashMap<Product, Integer> _productList = new HashMap<>();


    public Order(int orderNumber) {
        _orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return _orderNumber;

    }

    public String screenInfo() {

        return "Order Number : " + _orderNumber + "\n" + _state.getInfo(this);

    }

    public void nextState() {


        if(_state == null){

            _state = ShoppingCart.getInstancia();
        }else{

            _state = _state.NextState(this);

        }
        _state.OnSetState(this);


    }
    void goBack(){

        if(_state == null){

            throw  new IllegalStateException();
        }
        _state.PrevState(this);
    }


    public void addProduct(Product p) {

        _state.addProduct(this, p,_productList);
    }

    public void removeProduct(Product p) {
        _state.removeProduct(this, p,_productList);
    }



    public void modifyProduct(Product p, int quantity) {
        _state.modifyProduct(this, p, quantity,_productList);

    }
    public int getNumProducts(){

        return _productList.size();
    }
    public void pay() {

        if(_paid) throw new IllegalArgumentException();
        _state.pay(this);
    }
    public boolean isPaid(){

        return _paid;
    }

    public boolean cancel() {

        boolean wasCanceled = _state.cancel(this);

        if(wasCanceled){

            _state = Cancelled.getInstancia();
            _state.OnSetState(this);
        }

        return wasCanceled;
    }

    public void modifyLog(String line) {


        _log += line + "\n";
    }

    public String getLog() {

        return _log;
    }

    public void setPaid() {

        _paid = true;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        _paidDate = dtf.format(now);

    }

    public String getPaidDate() {

        return _paidDate;
    }




}
