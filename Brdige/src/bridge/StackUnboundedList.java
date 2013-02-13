package bridge;

public class StackUnboundedList<E> implements StackIF<E> {
	
	private List<E> list = new Nil<E>();
	private int length = 0;
	
	public StackUnboundedList() {}
	
	private abstract class List<E> {
		public abstract boolean isEmpty();
		public abstract E head ();
		public abstract List<E> tail ();
//		public abstract void setTail(List<E> aTail);
	}
	
	private class Nil<E> extends List<E> {
		public boolean isEmpty() {return true;}
		public E head() {return null;}
		public List<E> tail() {return null;}
//		public void setTail(List<E> aTail) {}
	}
	
	private class Cons<E> extends List<E> {
		private List<E> tail;
		private E head;
		public Cons(E aHead, List<E> aTail) {
			this.head = aHead;
			this.tail = aTail;
		}
		public boolean isEmpty() {return false;}
		public E head() {return head;}
		public List<E> tail() {return tail;}
//		public void setTail(List<E> aTail) {this.tail = aTail;}
	}
		
	public void push(E element) throws ArrayIndexOutOfBoundsException {
		Cons<E> temp = new Cons<E>(element, this.list);
		length++;
		this.list = temp;	
	}

	public E pop() {
		if (this.list.isEmpty())
			throw new IllegalStateException("Stack Empty");
		else
		{
			List<E> temp = list;
			list = list.tail();
			length--;
			System.out.println("list");
			return temp.head();
		}
	}

	public int length() {
		return this.length;
	}
}