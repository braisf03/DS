package e3.Strategys;

import e3.LoginStrategy;
import e3.UserDatabase;

import java.util.Objects;


public class UsernameS extends LoginStrategy {

    public static final Exception ISNT_VALID_USER = new Exception("El usario introducido no es valido (no tiene letras)");
    @Override
    public boolean validateId(String id) {

        if(NullOrEmptyString(id)){
            errorType = EMPTY_ID;
            return false;

        }

        for (char c : id.toCharArray()) {

            if(!Character.isDigit(c)){
                if (!UserDatabase.getUserNamesLogins().containsKey(id) ) {

                    errorType = WRONG_ID;
                    return false;

                }

                return true;
            }
        }

        errorType =ISNT_VALID_USER;
        return false;





    }

    @Override
    public boolean authenticatePassword(String id, String password) {

        if (NullOrEmptyString(password)) {
            errorType = EMPTY_PASSWORD;
            return false;
        }
        if (!Objects.equals(UserDatabase.getUserNamesLogins().get(id), password)) {

            errorType = WRONG_PASSWORD;
            return false;
        }
        return true;
    }
}
