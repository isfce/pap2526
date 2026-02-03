package util;

public class StackArray implements IStack {
	private int[] v;
	private int sommet;

	public StackArray(int taille) {
		v = new int[taille];
		sommet = 0;
	}

	@Override
	public void push(int elem) {
		v[sommet] = elem;
		sommet++;
	}

	@Override
	public int pop() {
		sommet--;
		return v[sommet];
	}

	@Override
	public int top() {

		return v[sommet - 1];
	}

	@Override
	public boolean empty() {
		return sommet == 0;
	}

}
