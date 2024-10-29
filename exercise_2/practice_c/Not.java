public class Not extends Exp {

	private Exp e;

	public Not(Exp a) {
		e = a;
	}

	public boolean eval() {
		return !e.eval();
	}

	public String toSExp() {
		return String.format("[not %s]", e.toSExp());
	}
}
