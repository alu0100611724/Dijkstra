package Dijkstra;

public class Edge {

	int from;		//接続元のシンボル番号
	int to;			//接続先のシンボル番号
	double cost;	//接続先に行くまでのコスト
	
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
