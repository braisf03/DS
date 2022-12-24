package e1.Productos;

public class RTX4090 extends Product{



    private static final RTX4090 _instancia = new RTX4090();
    private RTX4090() {
        _proID = 129;
        _stock = 10;
    }
    public static RTX4090 getInstancia() { return _instancia; }
}
