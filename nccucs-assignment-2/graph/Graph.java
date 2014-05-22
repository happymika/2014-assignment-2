package ps3.graph;

import java.util.*;

/**
*@author YuhRu Lin, NCCUCS, Taiwan.
*/

public class Graph {
	
	//Fields
	/** Name of the graph. */
	private String name;
	/** Number of nodes in this graph. */
	private int nodeQuantity;
    /** String -> WeightedNode: maps the names of nodes to the actual node **/
    private final Map<String, WeightedNode> nodes = new HashMap<String, WeightedNode>();
	/** String -> ArrayList<WeightedNode>: maps the names of nodes to the children list. */
	private final Map<String, ArrayList<WeightedNode>> Parents = new HashMap<String, ArrayList<WeightedNode>>();
	private final List<String> nodesList = new ArrayList<String>();

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
		ArrayList<WeightedNode> childrenList = new ArrayList<WeightedNode>();
		nodes.put(n.name(), n);
		Parents.put(n.name(), childrenList);
		nodesList.add(n.name());
	}

	/**
	*Add a edge between two nodes.
	*The edge is directional.
	*@param n1 Parent node.
	*@param n2 Child node.
	*@exception java.lang.NullPointerException if node dosen't exist.
	*/
	public void addEdge(WeightedNode n1, WeightedNode n2){
		Parents.get(n1).add(n2);
	}
	
	/**
	*List whole nodes(streets) in this graph.
	*/
	public String listNodes(){
		Collections.sort(nodesList);
		String nodesListStr = "";
		for(int i = 0 ; i < nodesList.size() ; i++){ 
			if(i != 0)
				nodesListStr += " ";
			nodesListStr += nodesList.get(i);
		}
		return nodesListStr;
	}
	
	/**
	*List whole children of node n.
	*@param n The node n's children will be listed.
	*@exception java.lang.NullPointerException if node dosen't exist.
	*/
	public String listChildren(WeightedNode n){
		//WeightedNode a = new WeightedNode("abc", 10);
		return " ";
	}
	
	
	public String findPath(WeightedNode start, WeightedNode end){
		//WeightedNodePath temp = new WeightedNodePath();
		return "";
	}
	
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
	
	public boolean doesNodeExist(WeightedNode n){
		if(nodes.get(n.name()) != null)
			return true;
		else
			return false;
	}
	
}