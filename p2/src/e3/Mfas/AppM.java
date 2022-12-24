package e3.Mfas;

import e3.IMfaStrategy;

public class AppM implements IMfaStrategy {
    @Override
    public String generateCode() {

        StringBuilder s = new StringBuilder(5);

        random.setSeed(random.nextInt() * 4L);

        for (int i = 0; i < 5; i++) {

            if(random.nextBoolean())s.append((char)(random.nextInt(26) + 'a'));
            else random.nextInt(9);
        }
        return s.toString();
    }


}
