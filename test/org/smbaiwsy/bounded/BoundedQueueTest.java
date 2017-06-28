package org.smbaiwsy.bounded;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoundedQueueTest {

	@Test(expected = IllegalStateException.class)
	public void testFull(){
		BoundedQueue<Integer> bq = new BoundedQueue<>(5);
		bq.enqueue(1);
		bq.enqueue(2);
		bq.enqueue(3);
		bq.enqueue(4);
		bq.enqueue(5);
		bq.enqueue(6);
	}
	@Test(expected = IllegalStateException.class)
	public void testEmpty(){
		BoundedQueue<Integer> bq = new BoundedQueue<>(5);
		bq.enqueue(1);
		bq.dequeue();
		bq.dequeue();
	}
	
	@Test
	public void testRound(){
		BoundedQueue<Integer> bq = new BoundedQueue<>(5);
		bq.enqueue(1);
		bq.enqueue(2);
		assertEquals(Integer.valueOf(1),bq.dequeue());
		assertEquals(Integer.valueOf(2),bq.dequeue());
		bq.enqueue(3);
		bq.enqueue(4);
		bq.enqueue(5);
		bq.enqueue(6);
		assertEquals(Integer.valueOf(3),bq.dequeue());
		assertEquals(Integer.valueOf(4),bq.dequeue());
		assertEquals(Integer.valueOf(5),bq.dequeue());
		assertEquals(Integer.valueOf(6),bq.dequeue());
	}

}
