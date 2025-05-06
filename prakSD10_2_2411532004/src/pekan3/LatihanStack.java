package pekan3;

import java.util.*;

public class LatihanStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack <Integer>();
		s.push(42);
		s.push(-3);
		s.push(17);
		
		System.out.println("nilai Stack: " + s);
		System.out.println("nilai Pop: " + s.pop());
		System.out.println("nilai Stack setelah pop= " + s);
		System.out.println("nilai peek: " + s.peek());
		System.out.println("nilai Stack setelah peek= " + s);

	}

}
