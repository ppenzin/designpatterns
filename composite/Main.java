/* Main.java: Driver class for testing the while-language composite classes.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 2013-02-04
 *
 */

public class Main {
	public static void main (String[] args) {
		Statement factorial = new Compound (
				new Assignment ("fact", new Expr()),
				new While (new Expr(), new Compound (
					new Assignment ("fact", new Expr()),
					new Assignment ("n", new Expr())
					)
				)
			);

		Statement mccarthy = new Compound (
				new Assignment ("n", new Expr()),
				new Assignment ("c", new Expr()),
				new While (new Expr(), new Conditional(
								new Expr(),
								new Compound(
										new Assignment("n", new Expr()),
										new Assignment("c", new Expr())
									),
								new Compound(
										new Assignment("n", new Expr()),
										new Assignment("c", new Expr())
									)
							)
					)
			);

		System.out.println("= First Example =");
		System.out.println(factorial.prettyPrint(0) + "\n");

		System.out.println("= Second Example =");
		System.out.println(mccarthy.prettyPrint(0));
	}
}
