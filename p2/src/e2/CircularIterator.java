package e2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class CircularIterator<E> implements Iterator<E> {

    List<E> list = new LinkedList<>();
    boolean canRemove = false;
    int pos = 0;

    @Override
    public boolean hasNext() {

        return !list.isEmpty();
    }

    @Override
    public E next() {

        if (list.isEmpty()) throw new NoSuchElementException();

        canRemove = true;
        pos = getPos(pos + 1);
        return list.get(getPos(pos - 1));

    }

    int getPos(int pos) {

        if (pos > (list.size() - 1)) return 0;
        else if (pos < 0) return list.size() - 1;
        return pos;
    }

    @Override
    public void remove() {


        if(list.isEmpty() || !canRemove) throw new IllegalStateException();
        list.remove(getPos(pos-1));
        pos = Math.max(pos - 1, 0);


        canRemove = false;
    }
}
