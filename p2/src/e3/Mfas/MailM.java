package e3.Mfas;

import e3.IMfaStrategy;

public class MailM implements IMfaStrategy {

    @Override
    public String generateCode() {

        StringBuilder s = new StringBuilder(8);
        random.setSeed(random.nextInt() +10);

        for (int i = 0; i < 8; i++) {
            s.append((char)(random.nextInt(26) + 'a'));
        }

        return s.toString();
    }
}
