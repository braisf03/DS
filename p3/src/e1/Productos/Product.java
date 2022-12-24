package e1.Productos;

public abstract class Product {


    protected int _proID;
    protected int _stock;

    public  boolean thereIsStock(){

        return _stock > 0;
    }

    public Product get(){

        _stock--;
        return this;
    }
    public void set(){

        _stock++;
    }
    public  int getStock(){
        return _stock;
    }

    public int getproID(){

        return _proID;
    }

    public void renewStockTo(int stock){

        _stock = stock;
    }

}
