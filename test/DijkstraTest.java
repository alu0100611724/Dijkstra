package test;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import Dijkstra.Dijkstra;


public class DijkstraTest {

	Dijkstra dijkstra = new Dijkstra();
	
	@Test
	public void DijkstraTest() {
		dijkstra.addNodeAndEdge(0, 1, 5);
		dijkstra.addNodeAndEdge(0, 2, 4);
		dijkstra.addNodeAndEdge(0, 3, 2);
		dijkstra.addNodeAndEdge(1, 0, 5);
		dijkstra.addNodeAndEdge(1, 2, 2);
		dijkstra.addNodeAndEdge(1, 5, 6);
		dijkstra.addNodeAndEdge(2, 0, 4);
		dijkstra.addNodeAndEdge(2, 1, 2);
		dijkstra.addNodeAndEdge(2, 3, 3);
		dijkstra.addNodeAndEdge(2, 4, 2);
		dijkstra.addNodeAndEdge(3, 0, 2);
		dijkstra.addNodeAndEdge(3, 2, 3);
		dijkstra.addNodeAndEdge(3, 4, 6);
		dijkstra.addNodeAndEdge(4, 2, 2);
		dijkstra.addNodeAndEdge(4, 3, 2);
		dijkstra.addNodeAndEdge(4, 5, 4);
		dijkstra.addNodeAndEdge(5, 1, 6);
		dijkstra.addNodeAndEdge(5, 4, 4);
		
		dijkstra.excute(0);
				
		ArrayList<Integer> route = dijkstra.getTransitionStartToGoal(0, 5);
		
		assertEquals(0, route.get(0), 0.0);
		assertEquals(2, route.get(1), 0.0);
		assertEquals(4, route.get(2), 0.0);
		assertEquals(5, route.get(3), 0.0);
	}

}
