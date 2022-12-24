package e3.Mfas;

import e3.IMfaStrategy;


public class SMSM implements IMfaStrategy {



    @Override
    public String generateCode() {



        StringBuilder s = new StringBuilder(5);
        random.setSeed(random.nextInt() ^ 2);

        for (int i = 0; i < 5; i++) {

            s.append(random.nextInt(9));

        }
        return s.toString();
    }
}
