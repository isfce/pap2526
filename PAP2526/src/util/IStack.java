package util;

public interface IStack<T> {
	public void push(T elem);
	
	public T pop();

	public T top();

	public boolean empty();

}
