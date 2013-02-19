package expr_nof;

import java.util.Hashtable;

public class VarFactory {
	private static VarFactory varFactory = new VarFactory();
	private VarFactory() {};
	private Hashtable table = new Hashtable();
	
	public static VarFactory getInstance() {return varFactory;}
	
	public Var getVar(String name) {
		if (!table.containsKey(name))
			table.put (name, new Var(name));
		return (Var) table.get(name);			
	}
}
