package bridge;

public class StackBoundedArray<E> implements StackIF<E> {
	private E array[];
	
	private int capacity;
	private int length;
	
	public StackBoundedArray (int capacity) {
		this.array = (E[])new Object[capacity];
		this.capacity = capacity;
		this.length = 0;
	}
	
	public void push(E element) throws ArrayIndexOutOfBoundsException {
		if (this.length == capacity)
			throw new ArrayIndexOutOfBoundsException("Full Stack");
		else {
			this.array[(capacity - this.length - 1)] = element;
			this.length++;
		}
	}
	
	public E pop() {
		if (length == 0) 
			throw new IllegalStateException("Empty Stack");
		else
		{
			E temp = array[capacity - this.length];
			length--;
			System.out.print("array");
			return temp;
		}
	}
			
	public int length() {
		return this.length;
	}	
}