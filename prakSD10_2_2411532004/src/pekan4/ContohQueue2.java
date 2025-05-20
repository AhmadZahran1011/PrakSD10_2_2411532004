package pekan4;

import java.util.Queue;
import java.util.LinkedList;

public class ContohQueue2 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < 6; i++)
			q.add(i);
			System.out.println("Element Anrtian "+ q);
		int hapus = q.remove();
		System.out.println("Hapus element = "+ hapus);
		System.out.println(q);
		
		int depan = q.peek();
		System.out.println("element depan = "+ depan);
		
		int banyak = q.size();
		System.out.println("Banyak element = "+ banyak);


	}

}
