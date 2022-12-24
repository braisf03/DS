package e2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TVRealityList<E> implements Iterable<E> {


    public List<E> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<E> candidatos) {
        this.candidatos = candidatos;
    }

    private List<E> candidatos = new LinkedList<>();

    public enum IteratorType {CIRCULAR, REBOTE}
    public IteratorType iteratorType;

    @Override
    public Iterator<E> iterator() {

        Iterator<E> iterator;

        if (iteratorType == IteratorType.CIRCULAR) {

            iterator = new CircularIterator<>();
            ((CircularIterator<E>) iterator).list = candidatos;

        } else {

            iterator = new ReboteIterator<>();
            ((ReboteIterator<E>) iterator).list = candidatos;
        }

        return iterator;


    }
}
