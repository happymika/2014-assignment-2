package ps3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ps3.graph.*;
import static org.junit.Assert.*;

public class GraphTest {
	Graph test1 = new Graph("Graph 1"); // a empty graph default. It can be modified.
	Graph test2 = new Graph("Graph 2"); // a empty graph
	Graph test3; // complete, correct sample
	
	@Before
	public void setUp(){
		test3 = new Graph("Graph 3");
		WeightedNode node1 = new WeightedNode("Taipei to Taichung", 10);
		WeightedNode node2 = new WeightedNode("Taichung to Kaohsiung", 15);
		WeightedNode node3 = new WeightedNode("Taichung to Tainan", 10);
		test3.addNode(node1);
		test3.addNode(node2);
		test3.addNode(node3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNoNameGraph() {
		Graph example = new Graph("");
	}
	
	@Test
	public void testGraph() {
		Graph example = new Graph("123");
	}

	@Test
	public void testAddNode() {
		WeightedNode node1 = new WeightedNode("Taipei to Taichung", 10);
		WeightedNode node2 = new WeightedNode("Taichung to Kaohsiung", 15);
		test1.addNode(node1);
		assertEquals(test1.size(), 1);
		test1.addNode(node2);
		assertEquals(test1.size(), 2);
	}
		
	@Test
	public void testAddEdge() {
		test3.addEdge("Taipei to Taichung", "Taichung to Kaohsiung");
		test3.addEdge("Taipei to Taichung", "Taichung to Tainan");
	}

	@Test
	public void testListNodes() {
		assertEquals(test3.listNodes(), "Taichung to Kaohsiung Taichung to Tainan Taipei to Taichung");
		WeightedNode tempNode = new WeightedNode("Kaohsiung to Pingtung", 3);
		test1.addNode(tempNode);
		assertEquals(test1.listNodes(), "Kaohsiung to Pingtung");
		test3.addNode(tempNode);
		assertEquals(test3.listNodes(), "Kaohsiung to Pingtung Taichung to Kaohsiung Taichung to Tainan Taipei to Taichung");
	}

	@Test
	public void testListChildren() {
		test3.addEdge("Taipei to Taichung", "Taichung to Tainan");
		String listStr = test3.listChildren("Taipei to Taichung");
		assertEquals(listStr, "Taichung to Tainan");
		
		test3.addEdge("Taipei to Taichung", "Taichung to Kaohsiung");
		listStr = test3.listChildren("Taipei to Taichung");
		assertEquals(listStr, "Taichung to Kaohsiung Taichung to Tainan");
	}

	@Ignore
	@Test
	public void testFindPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		assertTrue(test2.isEmpty());
		assertFalse(test3.isEmpty());
	}

	@Test
	public void testGetName() {
		assertEquals(test1.getName(), "Graph 1");
		assertEquals(test2.getName(), "Graph 2");
	}

	@Test
	public void testDoesNodeExist() {
		WeightedNode tempNode1 = new WeightedNode("Taipei to Kaohsiung", 1);
		assertFalse(test3.doesNodeExist("Taipei to Kaohsiung"));
		assertTrue(test3.doesNodeExist("Taipei to Taichung"));
		test1.addNode(tempNode1);
		assertTrue(test1.doesNodeExist("Taipei to Kaohsiung"));
	}
	
	@Test
	public void testSize() {
		assertEquals(test2.size(), 0);
		assertEquals(test3.size(), 3);
	}

}
