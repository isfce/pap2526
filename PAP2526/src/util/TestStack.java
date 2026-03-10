package util;

public class TestStack {

	public static void main(String[] args) {
		IStack<Integer> s1 = new StackList<>();// new StackArray<>(3);
		s1.push(3);
		s1.push(7);
		s1.push(10);
		s1.push(30);
		while (!s1.empty())
			System.out.println(s1.pop());

	}

}
