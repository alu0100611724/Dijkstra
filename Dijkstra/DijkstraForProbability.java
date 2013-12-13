package Dijkstra;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author cosmocleaner
 *
 */
public class DijkstraForProbability {

	ArrayList<Node> nodes;

	public DijkstraForProbability(){
		this.nodes = new ArrayList<Node>();
	}
	
	public void excute( int startNodeID ){
		
		getNode(startNodeID).renewCost(1.0);	//ゴールの確率は1.0
		
		while(true){
			Node doneNode = null;
			for( Node node : nodes ){
				if( node.getDone() || node.getCost() < 0 ){	//既に確定ノードは無視される
					continue;
				}
				if( doneNode == null || node.getCost() > doneNode.getCost() ){
					doneNode = node;
				}
			}
			if( doneNode == null ){
				break;
			}
			
			doneNode.done();
			for( Edge edge : doneNode.edges ){
				double costProbability = doneNode.getCost()*edge.getCost();
				
				if( getNode(edge.getTo()).getCost() < 0 || costProbability > getNode(edge.getTo()).getCost() ){
					getNode(edge.getTo()).renewCost(costProbability);
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
			transition.add(from);
			if( from == startID ){
				break;
			}
		}
		Collections.reverse(transition);
		return transition;
	}
	
	public Node getNode( int id ){
		for( Node node : nodes ){
			if( node.getID() == id ){
				return node;
			}
		}
		return null;
	}
	
	public void addNode( Node node ){
		this.nodes.add( node );
	}
	
}
