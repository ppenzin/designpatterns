package expr_nof;

import java.util.Hashtable;

public class VarFactory {
	private static VarFactory varFactory = new VarFactory();
	private VarFactory() {};
	private Hashtable table = new Hashtable();
	
	public static VarFactory getInstance() {return varFactory;}
	
	public Var getVar(String name, int line) {
		if (!table.containsKey(name))
			table.put (name, new VarPrim(name));
		return (Var) new VarLine ((VarPrim) table.get(name),line);			
	}
}
