package e2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TVRealityTest {


    TVReality reality = new TVReality();

    LinkedList<String> declareCandidatos() {

        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        return list;
    }


    @Test
    void selectCandidatesTest() {

        reality.realityList.setCandidatos(declareCandidatos());

        assertEquals("4",reality.selectCandidates(TVRealityList.IteratorType.CIRCULAR, 3));

        reality.realityList.setCandidatos(declareCandidatos());

        assertEquals("1",reality.selectCandidates(TVRealityList.IteratorType.REBOTE, 3));

    }

    @Test
    void removeTest() {

        reality.realityList.setCandidatos(new LinkedList<>());
        assertThrows(IllegalStateException.class, () -> reality.realityList.iterator().remove());

        reality.realityList.setCandidatos(declareCandidatos());
        assertThrows(IllegalStateException.class, () -> reality.realityList.iterator().remove());

        CircularIterator<String> iteratorC = new CircularIterator<>();
        iteratorC.list = declareCandidatos();
        iteratorC.next();
        iteratorC.remove();
        assertThrows(IllegalStateException.class, iteratorC::remove);


        ReboteIterator<String> iteratorR = new ReboteIterator<>();
        iteratorR.list = declareCandidatos();
        iteratorR.next();
        iteratorR.remove();
        assertThrows(IllegalStateException.class, iteratorR::remove);
    }

    @Test
    void hasNextTest() {


        CircularIterator<String> iteratorC = new CircularIterator<>();
        iteratorC.list = new LinkedList<>();
        assertFalse(iteratorC.hasNext());
        iteratorC.list = declareCandidatos();
        assertTrue(iteratorC.hasNext());


        ReboteIterator<String> iteratorR = new ReboteIterator<>();
        assertFalse(iteratorR.hasNext());
        iteratorR.list = declareCandidatos();
        assertTrue(iteratorR.hasNext());

    }

    @Test
    void nextTest() {

        CircularIterator<String> iteratorC = new CircularIterator<>();

        iteratorC.list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, iteratorC::next);

        iteratorC.list = declareCandidatos();
        assertEquals(iteratorC.next(),"1");


        iteratorC = new CircularIterator<>();
        iteratorC.list =  new LinkedList<>();
        iteratorC.list.add("1");
        iteratorC.list.add("2");
        iteratorC.next();
        iteratorC.next();
        assertEquals("1",iteratorC.next());


        ReboteIterator<String> iteratorR = new ReboteIterator<>();

        iteratorR.list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, iteratorR::next);

        iteratorR.list = declareCandidatos();
        assertEquals(iteratorR.next(),"1");

        iteratorR = new ReboteIterator<>();
        iteratorR.list =  new LinkedList<>();
        iteratorR.list.add("1");
        iteratorR.list.add("2");
        iteratorR.list.add("3");
        iteratorR.next();
        iteratorR.next();
        iteratorR.next();
        assertEquals("2",iteratorR.next());

    }
}