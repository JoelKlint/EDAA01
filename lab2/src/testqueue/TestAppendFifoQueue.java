package testqueue;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import queue.FifoQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAppendFifoQueue extends TestCase {
	private FifoQueue<Integer> myIntQueue;

	@Before
	public void setUp() throws Exception {
		myIntQueue = new FifoQueue<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		myIntQueue = null;
	}

	@Test
	public void testTwoNotEmpty() {
		FifoQueue<Integer> temp = new FifoQueue<Integer>();
		myIntQueue.offer(1);
		temp.offer(2);
		myIntQueue.append(temp);
		assertTrue("Wrong size when appending two non empty Queue",
				myIntQueue.size() == 2);
		assertEquals("temp not empty after appending", temp.size(), 0);
	}

	public void testTempEmpty() {
		FifoQueue<Integer> temp = new FifoQueue<Integer>();
		myIntQueue.offer(1);
		myIntQueue.append(temp);
		assertTrue("Wrong size when appending Temp empty",
				myIntQueue.size() == 1);
	}

	public void testMyIntQueueEmpty() {
		FifoQueue<Integer> temp = new FifoQueue<Integer>();
		temp.offer(2);
		myIntQueue.append(temp);
		assertEquals("Wrong size when appending MyIntQueue Empty",
				myIntQueue.size(), 1);
	}

	public void testBothEmpty() {
		FifoQueue<Integer> temp = new FifoQueue<Integer>();
		myIntQueue.append(temp);
		assertTrue("Wrong size when appending two Empty",
				myIntQueue.size() == 0);
	}
}
