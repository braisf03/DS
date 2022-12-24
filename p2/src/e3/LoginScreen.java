package e3;

import e3.Mfas.AppM;
import e3.Mfas.MailM;
import e3.Mfas.SMSM;
import e3.Strategys.MailS;
import e3.Strategys.PhoneS;
import e3.Strategys.UsernameS;


public class LoginScreen {

    private LoginStrategy loginStrategy;
    private IMfaStrategy mfaStrategy;

     public LoginScreen(LoginStrategy.LogType logType, IMfaStrategy.MfaType mfaType) {

        if(logType == null ||mfaType == null) throw new NullPointerException();


        switch (logType) {
            case MAIL -> setLoginStrategy(new MailS());
            case USERNAME -> setLoginStrategy(new UsernameS());
            case PHONE -> setLoginStrategy(new PhoneS());
        }
        switch (mfaType) {
            case MAIL -> setMfaStrategy(new MailM());
            case SMS -> setMfaStrategy(new SMSM());
            case APP -> setMfaStrategy(new AppM());
        }



    }

    public void setLoginStrategy(LoginStrategy loginStrategy) {

        if(loginStrategy == null) throw  new NullPointerException();
        this.loginStrategy = loginStrategy;

    }

    public void setMfaStrategy(IMfaStrategy mfaStrategy) {

        if(mfaStrategy== null) throw  new NullPointerException();
        this.mfaStrategy = mfaStrategy;
    }


    public String TryLogin(String user, String password) {

        if (Login(user, password)) {

            return "Login correcto" ;
        } else {

            return"No se pudo Logear : " + loginStrategy.errorType.getMessage() ;
        }
    }

    private boolean Login(String user, String password) {

        if (!loginStrategy.validateId(user)) return false;
        return loginStrategy.authenticatePassword(user, password);

    }




}
