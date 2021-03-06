
import java.util.*;
  
public class CompositeIterator<T extends Iteratable<T>> implements Iterator<T> {
	Stack<Iterator<T>> stack = new Stack<Iterator<T>>();
   
	public CompositeIterator(Iterator<T> iterator) {
		stack.push(iterator);
	}
   
	public T next() {
		if (hasNext()) {
			Iterator<T> iterator = stack.peek();
			
			T component = iterator.next();
			stack.push(component.createIterator());
			return component;
		} else {
			return null;
		}
	}
  
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator<T> iterator = stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}
	
	/*
	 * No longer needed as of Java 8
	 * 
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 *
	public void remove() {
		throw new UnsupportedOperationException();
	}
	*/
}


