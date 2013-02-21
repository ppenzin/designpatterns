package fib;

import java.io.PrintStream;

public class FibNumConcrete implements FibNumIF {

	private int place;
	
	public FibNumConcrete(int place) {this.place = place;}
	public int eval() {return evalRec(this.place);}
	private int evalRec(int place) {
			if (place == 0) {
				return 0;
			}
			else if (place == 1) {
				return 1;
			}
			else return (evalRec(place-1)+evalRec(place-2)); 
		}
}