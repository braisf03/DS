package e1.Productos;

public class Alcachofa extends Product{


    private static final Alcachofa _instancia = new Alcachofa();
    private Alcachofa() {
        _proID = 131;
        _stock = 10;
    }
    public static Alcachofa getInstancia() { return _instancia; }
}
