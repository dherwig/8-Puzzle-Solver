import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

/*
 * A* implementation of the 8-puzzle problem
 * 
 * @author Don Herwig
 */
public class ASTAR {
	
	/*
	 * This method prints the solution by recursively backtracking
	 * through parent nodes.
	 * 
	 * @param goal 
	 * 				the goal node found during the search
	 */
	public static void solution(Node goal){
		
		//print root node, base case
		if(goal.getDepth()==0){
			System.out.println("Step " + goal.getPathCost() + ": " + goal.getAction());
			System.out.println(Arrays.toString(goal.getState()));
		}else{
			Node parent = goal.getParent();
			solution(parent);
			System.out.println("Step " + goal.getPathCost() + ": " + goal.getAction());
			System.out.println(Arrays.toString(goal.getState()));
			
		}
	}


	/*
	 * This method performs A* search on a root node
	 * 
	 *@param root the root to begin at
	 *
	 *returns true of false based on whether a goal was found
	 */
	public static boolean astar(Node root){
		Integer[] goal = {0,1,2,3,4,5,6,7,8};
		
		//created comparator to give desired priority when removing nodes
		PriorityQueueComparator comparator = new PriorityQueueComparator();
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(comparator);
		Set<Node> visited = new HashSet<Node>();
		frontier.offer(root);
		
		/*
		 * A* search similar to BFS and DFS.  The next goal to expand is 
		 * chosen based on the defined priority of the queue
		 */
		while (!frontier.isEmpty()){
			Node current = frontier.poll();
			
			if(!visited.contains(current)){
				if(Arrays.equals(current.getState(), goal)){
					System.out.println("Goal Found!");
					solution(current);
					return true;
				}
			    
				visited.add(current);
				current.astarChildren(current,frontier);
			}
		}
		return false;
				
	}
	public static void main(String[] args){
		//define the initial state of the puzzle
		Integer[] initial = {0,3,5,4,2,7,6,8,1};
		Node root = new Node(initial,null,"none",0,0);
		if(!astar(root)){
			System.out.println("Failed to find goal");
		}
	}
}
