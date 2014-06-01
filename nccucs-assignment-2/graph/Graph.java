package ps3.graph;

import java.util.*;

import junit.framework.Test;

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
	*@throws IllegalArgumentException if the name is empty
	*/
	public Graph(String name){
		if(name == ""){
			throw new IllegalArgumentException("The name is empty.");
		}
		else{
			this.name = name;
			this.nodeQuantity = 0;
		}
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
		nodeQuantity++;
	}

	/**
	*Add a edge between two nodes.
	*The edge is directional.
	*@param n1 Parent node.
	*@param n2 Child node.
	*@exception java.lang.NullPointerException if node dosen't exist.
	*/
	public void addEdge(String n1, String n2){
		Parents.get(n1).add(nodes.get(n2));
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
	public String listChildren(String n){
		//WeightedNode a = new WeightedNode("abc", 10);
		ArrayList<WeightedNode> tempChildrenList = Parents.get(n);
		Collections.sort(tempChildrenList);
		String childrenListStr = "";
		for(int i = 0 ; i < tempChildrenList.size() ; i++){ 
			if(i != 0)
				childrenListStr += " ";
			childrenListStr += tempChildrenList.get(i).name();
		}
		return childrenListStr;
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
	
	public boolean doesNodeExist(String name){
		if(nodes.get(name) != null)
			return true;
		else
			return false;
	}
	
	/**
	*Get the size information of the graph. 
	*"Size" means the number of nodes in the graph. 
	*@return the quantity of nodes in the graph.
	*/
	public int size(){
		return this.nodeQuantity;
	}
	
}
