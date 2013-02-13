package bridge;

public interface StackIF<E> {
	public void push(E element) throws ArrayIndexOutOfBoundsException;
	public E pop();
	public int length();
}
