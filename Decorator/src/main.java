import java.util.ArrayList;


import fib.*;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FibNumIF fibNum = null;
		for (int i = 0; i < 40; i++) {
			fibNum= new FibNumConcrete(i);
			System.out.println(i+": "+fibNum.eval());
		}
		FibNumTimed timedFibNum = new FibNumTimed(fibNum);
		System.out.println(timedFibNum.eval()+": "+timedFibNum.elapsed()+"ms");
	}

}
