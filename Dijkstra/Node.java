package Dijkstra;

import java.util.ArrayList;

public class Node {
	
	ArrayList<Edge> edges;			//ノードから接続しているエッジ情報
	int nodeID;						//ノードの番号
	int fromID = -1;				//確定した接続先のシンボル
	boolean done;					//ノードの確定フラグ（探索終了）
	double doneCost;				//シンボルにくるまでのコスト
	
	public Node( int id ){
		this.nodeID = id;
		this.edges = new ArrayList<Edge>();
		this.fromID = -1;
		this.done = false;
		this.doneCost = -1;
	}
	
	public void init(){
		fromID = -1;
		done = false;
		doneCost = -1;
	}
	
	public void addEdge( int to, double cost ){
		Edge existEdge = getEdge(to);
		if( existEdge == null ){
			Edge edge = new Edge(nodeID, to, cost);
			edges.add( edge );
		} else {	//エッジが存在していた場合更新
			existEdge.cost = cost;
		}
	}
	
	/**
	 * エッジのコストを上書きする
	 * @param to
	 * @param renewCost
	 */
	public void renewEdge( int toID, double renewCost ){
		Edge edge = getEdge(toID);
		if( edge != null ){
			edge.cost = renewCost;
		}
	}
	
	public Edge getEdge( int toID ){
		for( Edge edge : edges ){
			if( edge.to == toID){
				return edge;
			}
		}
		return null;
	}
	
	public ArrayList<Edge> getEdges(){
		return edges;
	}
	
	public void done(){
		this.done = true;
	}
	
	public boolean getDone(){
		return this.done;
	}
	
	public double getCost(){
		return this.doneCost;
	}
	
	public int getID(){
		return this.nodeID;
	}
	
	public void renewCost( double cost ){
		this.doneCost = cost;
	}
	
	public void renewFrom( int id ){
		this.fromID = id;
	}
	
	public int getFromID(){
		return this.fromID;
	}
	
}
