public class Bool extends Exp {

	private boolean val;

	public Bool(boolean val) {
		this.val = val;
	}

	public boolean eval() {
		return this.val;
	}
}
