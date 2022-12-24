package e2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ReboteIterator<E> implements Iterator<E> {

    List<E> list = new LinkedList<>();

    boolean canRemove = false;
    int pos = 0;

    int dir = 1;

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public E next() {
        if (list.isEmpty()) throw new NoSuchElementException();

        canRemove = true;
        pos = getPos(pos + dir, true);
        return list.get(pos - dir);
    }

    int getPos(int pos, boolean changeDir) {

        if (list.size() == 1) return 0;
        else if (pos > list.size() - 1) {
            if (changeDir) dir = -dir;
            return list.size() - 2;
        } else if (pos < 0) {
            if (changeDir) dir = -dir;
            return 1;
        }
        return pos;
    }

    @Override
    public void remove() {

        if (list.isEmpty() || !canRemove) throw new IllegalStateException();
        list.remove(getPos(pos - dir, false));

        pos = dir > 0 ? Math.max(pos - 1, 0) : pos;

        canRemove = false;

    }
}
