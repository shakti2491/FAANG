package company.recent.redfin;

import java.util.Iterator;

public interface List<T>
{
    int size();
    boolean isEmpty();
    boolean contains();
    Iterator<T> iterator();
    boolean add(T var);
    boolean remove(int i);
}
