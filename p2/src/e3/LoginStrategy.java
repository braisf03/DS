package e3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class LoginStrategy {

    public Exception errorType;

    public static final Exception WRONG_PASSWORD = new Exception("Contraseña incorrecta");
    public static final Exception EMPTY_PASSWORD = new Exception("No hay contraseña");
    public static final Exception WRONG_ID = new Exception("Id incorrecto");
    public static final Exception EMPTY_ID = new Exception("No hay Id");
    public enum LogType {PHONE, MAIL, USERNAME}




    public abstract boolean validateId(String id);
    public abstract boolean authenticatePassword(String id, String password);

    public boolean NullOrEmptyString(String string) {

        return string == null || string.length() == 0 || string.contains(" ");  //por ahora nada puede tener espacios, pero se puede cambiar
    }
}
