package bridge;

public class Stack<E> {

	public Stack() {}
	StackIF<E> stack = new StackBoundedArray<E>(10);
		
	public void push(E element) {
		try {
			stack.push(element);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
			StackIF<E> temp = this.stack;
			this.stack = new StackUnboundedList<E>();
			this.swap(temp, this.stack);
			stack.push(element);
		}
	}

	public E pop() {
		return stack.pop();
	}

	public int length() {
		return stack.length();
	}
	
	private void swap(StackIF<E> source, StackIF<E> destination) {
		E element = (E) source.pop();
		if (source.length() > 0)
			swap(source, destination);
		destination.push (element);
	}
}
