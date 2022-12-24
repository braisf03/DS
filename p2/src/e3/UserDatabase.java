package e3;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {

    public static Map<String, String> getMailsLogins() {
        return mailsLogins;
    }

    public static Map<String, String> getPhonesLogins() {
        return phonesLogins;
    }

    public static Map<String, String> getUserNamesLogins() {
        return userNamesLogins;
    }

    private static   Map<String, String> mailsLogins = new HashMap<>();
    private static Map<String, String> phonesLogins = new HashMap<>();
    private  static Map<String, String> userNamesLogins = new HashMap<>();


    public  static  void addUser(LoginStrategy.LogType logType,String user,String password){

        switch (logType) {

            case PHONE -> phonesLogins.put(user, password);

            case USERNAME -> userNamesLogins.put(user, password);

            case MAIL -> mailsLogins.put(user, password);

        }

    }

}
