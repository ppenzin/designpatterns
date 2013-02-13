/* 
Bridge (4.3.1)
A use of the Bridge pattern is to dynamically change the implementation of an object. Design, code and test a stack with the following characteristics. Initially, a stack is implemented by an array and, consequently, has a fixed size. If there is a need to push an element on a full fixed-size stack, the implementation of stack is replaced by a linked list and, consequently, the stack becomes unbounded.
*/

package bridge;

public class Driver {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		for (int i = 0; i < 10; i++) {
			int j = stack.pop();
			System.out.println(j);
		}
		for (int i = 0; i < 12; i++) {
			stack.push(i);
		}
		for (int i = 0; i < 12; i++) {
			int j = stack.pop();
			System.out.println(j);
		}
	}
}