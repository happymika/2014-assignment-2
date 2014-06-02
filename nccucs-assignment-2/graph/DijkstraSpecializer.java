package ps3.graph;

import java.util.*;

public class DijkstraSpecializer implements PathFinderSpecializer<WeightedNode>  {
	public Graph graph;
	
	public DijkstraSpecializer(Graph graph) {
        this.graph = graph;
    }
	
	public Iterable<WeightedNode> expandNode(WeightedNode node){
		ArrayList<WeightedNode> tempChildrenArrayList = graph.children(node);
		Iterator<WeightedNode> iterator = tempChildrenArrayList.iterator();
        return (Iterable<WeightedNode>) iterator;
	}

	@Override
	public int compare(Path<WeightedNode> o1, Path<WeightedNode> o2) {
		return Double.compare(o1.cost(), o2.cost());
	}
		
}
