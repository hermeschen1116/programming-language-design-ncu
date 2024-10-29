public class Main {
	public static void main(String[] args) {
		Exp[] practiceB = {
			new Or(new Bool(true), new Bool(false)),
			new Or(new Bool(false), new Bool(false)),
			new And(new Bool(true), new Bool(true)),
			new And(new Bool(false), new Bool(true)),
			new Not(new Bool(false)),
			new Not(new Or(new Bool(true), new And(new Bool(false), new Bool(true))))
		};
		for(Exp e : practiceB) System.out.println(e.eval());
	}
}
