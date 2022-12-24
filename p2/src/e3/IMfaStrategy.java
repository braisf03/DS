package e3;

import java.util.Random;

public interface IMfaStrategy {


    enum MfaType{SMS,MAIL,APP}
    Random random = new Random();
    String generateCode ();



}
