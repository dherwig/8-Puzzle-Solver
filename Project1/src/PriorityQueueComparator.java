import java.util.Comparator;

/*
 * Implementation of a comparator for the priority queue in the A* search
 * 
 * @author Don Herwig
 */
public class PriorityQueueComparator implements Comparator<Node> {
	
	/*
	 * A node is given higher priority if it has a lower sum of 
	 * current path cost and cost to go 
	 */
	@Override
	public int compare(Node a, Node b){
		if((a.getPathCost()+a.getCost2Go()) > (b.getPathCost()+b.getCost2Go())){
			return 1;
		}else if((b.getPathCost()+b.getCost2Go()) > (a.getPathCost()+ a.getCost2Go())){
			return -1;
		}else{
			return 0;
		}
	}
}
