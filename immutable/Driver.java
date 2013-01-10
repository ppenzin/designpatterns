
public class Driver {

	public static void main(String[] args) {
		
		MutablePosition mutable = new MutablePosition(5,10);
		ImmutablePosition immutable = new ImmutablePosition(5,10);
		
		mutable.setX(10);
		immutable.setX(20);
	}

}
