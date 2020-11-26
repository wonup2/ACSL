
import java.util.*;
public class Stack_Queue {

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<Integer>();
		
		
		st.add(1);
		st.add(2);
		st.add(3);
		System.out.println(st);
		
		System.out.println(st.pop());
		
		System.out.println(st);
		
		System.out.println(st.peek());
		
		System.out.println(st);
		
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(1);		
		q.add(2);
		q.add(3);
		
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q);
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q);

		/*
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(10);
		pq.add(4);
		pq.add(6);
		pq.add(20);
		pq.add(15);
		
		System.out.println(pq.peek());
		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq.peek());
		*/
	}
}
