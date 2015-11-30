import java.util.Iterator;

public interface Iteratable<T>  {
	Iterator<T> createIterator();
}
