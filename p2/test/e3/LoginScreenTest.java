package e3;

import e3.Strategys.MailS;
import e3.Strategys.PhoneS;
import e3.Strategys.UsernameS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginScreenTest {

    LoginScreen loginScreen;

    @Test
    void declareLoginScreenTest() {

        assertThrows(NullPointerException.class, () -> loginScreen = new LoginScreen(null, null));

    }

    @Test
    void TrySetters() {

        loginScreen = new LoginScreen(LoginStrategy.LogType.PHONE, IMfaStrategy.MfaType.SMS);
        assertThrows(NullPointerException.class, () -> loginScreen.setLoginStrategy(null));
        assertThrows(NullPointerException.class, () -> loginScreen.setMfaStrategy(null));


    }

    @Test
    void LoginTest() {


        loginScreen = new LoginScreen(LoginStrategy.LogType.PHONE, IMfaStrategy.MfaType.SMS);
        UserDatabase.addUser(LoginStrategy.LogType.PHONE ,"91120198", "vivaalbacete");

        assertEquals("No se pudo Logear : " + PhoneS.EMPTY_ID.getMessage() , loginScreen.TryLogin("", "vivaalbacete"));
        assertEquals( "No se pudo Logear : " + PhoneS.EMPTY_PASSWORD.getMessage() , loginScreen.TryLogin("91120198", ""));


        assertEquals("No se pudo Logear : " + PhoneS.EMPTY_ID.getMessage() , loginScreen.TryLogin(null, "vivaalbacete"));
        assertEquals("No se pudo Logear : " + PhoneS.EMPTY_PASSWORD.getMessage() , loginScreen.TryLogin("91120198", null));

        assertEquals( "No se pudo Logear : " + PhoneS.IS_NOT_PHONENUMBER.getMessage() , loginScreen.TryLogin("jose", "vivaalbacete"));
        assertEquals( "Login correcto" , loginScreen.TryLogin("91120198", "vivaalbacete"));
        assertEquals("No se pudo Logear : " + UsernameS.WRONG_PASSWORD.getMessage() , loginScreen.TryLogin("91120198", "vivaagaloicia"));
        assertEquals( "No se pudo Logear : " + UsernameS.WRONG_ID.getMessage() , loginScreen.TryLogin("91120191", "vivamurcia"));


        loginScreen = new LoginScreen(LoginStrategy.LogType.MAIL, IMfaStrategy.MfaType.SMS);
         UserDatabase.addUser(LoginStrategy.LogType.MAIL,"dasd@mail.com", "vivaalbacete");

        assertEquals( "No se pudo Logear : " + MailS.IS_NOT_MAIL.getMessage() , loginScreen.TryLogin("jose", "vivaalbacete"));
        assertEquals("Login correcto" , loginScreen.TryLogin("dasd@mail.com", "vivaalbacete"));
        assertEquals("No se pudo Logear : " + UsernameS.WRONG_PASSWORD.getMessage() , loginScreen.TryLogin("dasd@mail.com", "vivamurcia"));
        assertEquals( "No se pudo Logear : " + UsernameS.WRONG_ID.getMessage() , loginScreen.TryLogin("dasd21@mail.com", "vivavadad"));

        loginScreen = new LoginScreen(LoginStrategy.LogType.USERNAME, IMfaStrategy.MfaType.SMS);
        UserDatabase.addUser(LoginStrategy.LogType.USERNAME,"Jersis", "vivaalbacete");

        assertEquals(  "No se pudo Logear : " + UsernameS.ISNT_VALID_USER.getMessage() , loginScreen.TryLogin("121313", "vivaalbacete"));
        assertEquals( "Login correcto" , loginScreen.TryLogin("Jersis", "vivaalbacete"));
        assertEquals("No se pudo Logear : " + UsernameS.WRONG_PASSWORD.getMessage() , loginScreen.TryLogin("Jersis", "vivamuricae"));
        assertEquals("No se pudo Logear : " + UsernameS.WRONG_ID.getMessage() , loginScreen.TryLogin("Jersis2", "vivamurcia"));


    }

}