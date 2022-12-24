package e2;

import java.util.Iterator;

public class TVReality {

    TVRealityList<String> realityList = new TVRealityList<>();


    public String selectCandidates(TVRealityList.IteratorType type, final int k) {

        realityList.iteratorType = type;
        int pos = 1;
        for (Iterator<String> i = realityList.iterator(); i.hasNext(); pos++) {

            i.next();
            if (pos == k) {
                pos = 0;
                i.remove();
            }
            if (realityList.getCandidatos().size() == 1) break;

        }


        return realityList.getCandidatos().get(0);


    }
}
