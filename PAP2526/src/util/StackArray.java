package util;

public class StackArray<T> implements IStack<T> {
	private T[] v;
	private int sommet;
	private int increment = 10;
	private int maxi=0;

	@SuppressWarnings("unchecked")
	public StackArray(int taille) {
		v = (T[]) new Object[taille];
		sommet = 0;
	}

	@Override
	public void push(T elem) {
		if (sommet == v.length)
			agrandirVect();
		v[sommet] = elem;
		sommet++;
		maxi=Math.max(maxi, sommet);
	}

	@SuppressWarnings("unchecked")
	private void agrandirVect() {
		T[] v2 = (T[]) new Object[v.length + increment];
		System.arraycopy(v, 0, v2, 0, v.length);
		v = v2;
		// System.out.println("Grow to "+v.length);
	}

	@Override
	public T pop() {
		sommet--;
		T tmp = v[sommet];
		v[sommet] = null;
		return tmp;
	}

	@Override
	public T top() {
		return v[sommet - 1];
	}

	@Override
	public boolean empty() {
		return sommet == 0;
	}

	public int getMaxi() {
		return maxi;
	}
	

}
