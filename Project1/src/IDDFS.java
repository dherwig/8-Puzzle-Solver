import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

/*
 * Iterative Deepening Depth-First Search implementation of 
 * the 8-puzzle problem
 * 
 * @author Don Herwig
 */
public class IDDFS {
	
	/*
	 * This method prints the solution by recursively backtracking
	 * from the goal node through the parent nodes
	 * 
	 * @param goal 
	 * 				the goal node found during the search
	 */
	public static void solution(Node goal){
		
		//print the root node
		if(goal.getDepth()==0){
			System.out.println("Step " + goal.getPathCost() + ": " + goal.getAction());
			System.out.println(Arrays.toString(goal.getState()));
		}else{
			//recursively print all other nodes
			Node parent = goal.getParent();
			solution(parent);
			System.out.println("Step " + goal.getPathCost() + ": " + goal.getAction());
			System.out.println(Arrays.toString(goal.getState()));
			
		}
	}
	
	/*
	 * This method perform depth limited search from a starting node
	 * 
	 * @param node	the node to begin searching from
	 * 
	 * @param limit the lowest depth to search to
	 */
	public static String dls(Node node, int limit){
		Integer[] goal = {0,1,2,3,4,5,6,7,8};
		Stack<Node> frontier = new Stack<Node>();
		Set<Node> visited = new HashSet<Node>();
		
		frontier.push(node);
		
		/*
		 *implement a depth first search but don't expand children nodes 
		 *if parent is at the limit depth
		 */
		while (!frontier.empty()){
			Node current = frontier.pop();

			if(!visited.contains(current)){
				
				//the state, or position of the tiles, is stored as an array, check it against goal
				if(Arrays.equals(current.getState(), goal)){
					System.out.println("Goal Found!");
					solution(current);
					return "success";
				}
				
				visited.add(current);
				
				//add children to frontier if current node isn't at limit
				if(current.getDepth() < limit){
					current.iddfsChildren(current, frontier, limit);
				}
			}
			
			if(frontier.empty()&&current.getDepth()<limit){
				return "failure";
			}
		}
		return "cutoff";
	}
	
	/*
	 * This method performs iterative deepening depth first search on a root node
	 * 
	 * @param the root to start at
	 * 
	 * returns true if goal is found
	 */
	public static boolean iddfs(Node root){
		//repeatedly perform depth limited search, increasing limit each time
		for(int i = 0; i <=20; i++){
			String result = dls(root, i);
			if(result.equals("failure")){
				return false;
			}
			if(result.equals("success")){
				return true;
			}
		
		}
		
		return false;
	}
	public static void main(String[] args){
		//define initial state
		Integer[] initial = {0,3,5,4,2,7,6,8,1};
		//define first node of the tree
		Node first = new Node(initial,null,"none",0,0);
		if(!iddfs(first)){
			System.out.println("Failed to find goal");
		}
		
		
	}
}
