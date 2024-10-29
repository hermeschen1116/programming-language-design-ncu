public class Main {

	public static void main(String[] args) {
		Exp[] practiceA = {
			new Int(2024),
			new PlusExp(new Int(20), new Int(24)),
			new MinusExp(new Int(11), new Int(3)),
			new MinusExp(new Int(2024), new MinusExp(new Int(30), new Int(20))),
		};
		for (Exp e : practiceA) System.out.println(e.toSExp());
	}
}
