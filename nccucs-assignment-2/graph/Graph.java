package ps3.graph;

/**
*@author YuhRu Lin, NCCUCS, Taiwan.
*/

public class Graph {
	
	//Fields
	/** Name of the graph. */
	private String name;
	/** Number of nodes in this graph. */
	private int nodeQuantity;

	//Methods
	/**
	*Constructs a new empty graph with the specified name.
	*@effects constructs a new graph with the name
	*/
	public Graph(String name){
		this.name = name;
		this.nodeQuantity = 0;
	}
	
	/**
	*Add a node(street) to this graph.
	*@modifies this
	*@effects add node n to the graph.
	*@throws java.lang.NullPointerException if node dosen't exist.
	*/
	public void addNode(WeightedNode n){
		
	}

	/**
	*Add a edge between two nodes.
	*The edge is directional.
	*@param n1 Parent node.
	*@param n2 Child node.
	*@exception java.lang.NullPointerException if node dosen't exist.
	*/
	public void addEdge(WeightedNode n1, WeightedNode n2){}
	
	/**
	*List whole nodes(streets) in this graph.
	*/
	public void listNodes(){}
	
	/**
	*List whole children of node n.
	*@param n The node n's children will be listed.
	*@exception java.lang.NullPointerException if node dosen't exist.
	*/
	public void listChildren(WeightedNode n){}
	
	
	public void findPath(WeightedNode start, WeightedNode end){}
	
	/**
	*Check this graph is empty or not.
	*@return if the graph is empty, then return true.
	*/
	public boolean isEmpty(){
		if(nodeQuantity == 0)
			return true;
		else
			return false;
		
	} 
	
	public String getName(){
		return this.name;
	} 
	
}
