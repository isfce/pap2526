package util;

public class StackList<T> implements IStack<T> {
	private Maillon<T> sommet;

	@Override
	public void push(T elem) {
		sommet = new Maillon<T>(elem, sommet);
	}

	@Override
	public T pop() {
		T tmp = sommet.info();
		sommet = sommet.suiv();
		return tmp;
	}

	@Override
	public T top() {
		return sommet.info();
	}

	@Override
	public boolean empty() {
		return sommet == null;
	}

}

record Maillon<T>(T info, Maillon<T> suiv) {
};
