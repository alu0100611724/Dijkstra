package Dijkstra;

import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {

	ArrayList<Node> nodes;

	public Dijkstra(){
		this.nodes = new ArrayList<Node>();
	}
	
	public void initNodes(){
		for( Node node : nodes ){
			node.init();
		}
	}

	/**
	 * 
	 * @param startNodeID
	 */
	public void excute( int startNodeID ){
		initNodes();
		getNode(startNodeID).renewCost(0.0);

		while(true){
			Node doneNode = null;
			for( Node node : nodes ){
				if( node.getDone() || node.getCost() < 0 ){
					continue;
				}
				if( doneNode == null || node.getCost() < doneNode.getCost() ){
					doneNode = node;
				}
			}
			if( doneNode == null ){
				break;
			}

			doneNode.done();
			for( Edge edge : doneNode.edges ){
				double cost = doneNode.getCost() + edge.getCost();

				if( getNode(edge.getTo()).getCost() < 0 || cost < getNode(edge.getTo()).getCost() ){
					getNode(edge.getTo()).renewCost(cost);
					getNode(edge.getTo()).renewFrom(doneNode.getID());
				}
			}
		}
	}

	/**
	 *
	 * @param startID
	 * @param goalID
	 * @return
	 */
	public ArrayList<Integer> getTransitionStartToGoal( int startID, int goalID ){
		ArrayList<Integer> transition = new ArrayList<Integer>();

		transition.add( goalID );
		while(true){
			int to = transition.get(transition.size()-1);
			int from = getNode(to).getFromID();
			if( from < 0){	
				break;
			}

			transition.add(from);
			if( from == startID ){
				break;
			}
		}
		Collections.reverse(transition);
		return transition;
	}

	public Node getNode( int id ){
		if( nodes.size() > 0 ){
			for( Node node : nodes ){
				if( node.getID() == id ){
					return node;
				}
			}
		}
		return null;
	}

	public void addNode( Node node ){
		this.nodes.add( node );
	}

	public void addNodeAndEdge( int fromID, int toID, double cost){
		Node node = getNode(fromID);
		if( node != null ){
			node.addEdge(toID, cost);
		} else {
			node = new Node(fromID);
			node.addEdge(toID, cost);
			addNode(node);
		}
		
		if( getNode(toID) == null ){
			Node toNode = new Node(toID);
			addNode(toNode);
		}
	}
	
	/**
	 * 
	 */
	public void showAllNodeAndEdge(){
		System.out.println("!!!!! dijkstra node and edge !!!!!" );
		for( Node node : nodes ){
			System.out.print("node:" + node.nodeID);
			for( Edge edge : node.edges){
				System.out.print(" edge:" + edge.to + "(" + edge.cost + ")");
			}
			System.out.println("");
		}
	}
}
