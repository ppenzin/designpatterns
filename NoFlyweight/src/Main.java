package src;
import expr_nof.*;
import statement.*;


/**
 *  Driver for a Composite pattern example.
 *  Composite objects are programs in a simple "while" language
 *  defined by the following informal syntax:
 *  <PRE>
 *      Statement   ::= Assignment | Conditional | While | Compound
 *      Assignment  ::= Var := Expr
 *      Conditional ::= if Expr then Statement else Statement
 *      While       ::= while Expr do Statement
 *      Compound    ::= begin Statement; ...; Statement end
 *  </PRE>
 *  The main method constructs and pretty prints the following
 *  program
 *  <PRE>
 *      begin
 *        fact = 1;
 *        while (n > 1) do
 *          begin
 *            fact := fact * n;
 *            n := n - 1
 *          end
 *      end
 *  </PRE>
 */
public class Main {
    /** Usual entry point. Constructs and pretty prints an example program. */
    public static void main (String [] arg) {
        Statement factorial = new Compound (
            new Assignment (new Var("fact"), new Var ("1")),
            new While (new Gt(new Var("n"),new Var("1")), new Compound (
                new Assignment (new Var("fact"), (new Mul(new Var("fact"),new Var("n")))),
                new Assignment (new Var("n"), new Sub(new Var("n"), new Var("1"))))));
        factorial.print (System.out, 0);
        System.out.println ();
    }
}
