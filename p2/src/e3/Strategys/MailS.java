package e3.Strategys;

import e3.LoginStrategy;
import e3.UserDatabase;

import java.util.Objects;

public class MailS extends LoginStrategy {

    public static final Exception IS_NOT_MAIL = new Exception("El id no es un correo");

    @Override
    public boolean validateId(String id) {

        if(NullOrEmptyString(id)){

            errorType = EMPTY_ID;
            return false;

        }
        if(!id.contains("@") || !id.contains(".")){
            errorType = IS_NOT_MAIL;
            return false;
        }

        if (!UserDatabase.getMailsLogins().containsKey(id) ) {

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
        if (!Objects.equals(UserDatabase.getMailsLogins().get(id), password)) {

            errorType = WRONG_PASSWORD;
            return false;
        }
        return true;
    }
}
