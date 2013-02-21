package fib;

import java.io.PrintStream;

public class FibNumTimed implements FibNumIF, TimeDecoratorIF{

	private FibNumIF fibNum;
	private long calcTime = -1;
	
	public FibNumTimed(FibNumIF fibNum) {
		this.fibNum = fibNum;
	}
	@Override
	public int eval() {
		long startTime = System.currentTimeMillis();
		int temp = fibNum.eval();
		this.calcTime = System.currentTimeMillis() - startTime;
		return temp;
	}
	
	public long elapsed() {return calcTime;}
}
