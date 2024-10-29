public class Main {

	public static void main(String[] args) {
		Exp[] practiceC = {
			new Bool(false),
			new And(new Bool(true), new Bool(true)),
			new Or(new Bool(true), new And(new Bool(true), new Bool(false))),
			new Not(new Or(new Bool(true), new And(new Bool(false), new Bool(true)))),
		};
		for (Exp e : practiceC) System.out.println(e.toSExp());
	}
}
