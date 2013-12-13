package Dijkstra;

public class Edge {

	int from;		
	int to;			
	double cost;	
	
	public Edge( int from, int to, double cost ){
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	public int getTo(){
		return this.to;
	}
	
	public double getCost(){
		return this.cost;
	}
}
