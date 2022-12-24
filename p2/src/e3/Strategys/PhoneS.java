package e3.Strategys;

import e3.LoginStrategy;
import e3.UserDatabase;

import java.util.Objects;

public class PhoneS extends LoginStrategy {

    public static final Exception IS_NOT_PHONENUMBER =  new Exception("El id no es un numero de telefono");
    @Override
    public boolean validateId(String id) {

        if(NullOrEmptyString(id)){
            errorType = EMPTY_ID;
            return false;

        }
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {


            errorType = IS_NOT_PHONENUMBER;
            return false;
        }

        if (!UserDatabase.getPhonesLogins().containsKey(id)) {

            errorType = WRONG_ID;
            return false;

        }

        return true;

    }

    @Override
    public boolean authenticatePassword(String id, String password) {

        if (NullOrEmptyString(password)) {
            errorType = EMPTY_PASSWORD;
            return false;
        }
        if (!Objects.equals(UserDatabase.getPhonesLogins().get(id), password)) {

            errorType = WRONG_PASSWORD;
            return false;
        }
        return true;
    }

}
