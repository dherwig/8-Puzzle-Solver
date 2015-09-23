import java.util.Stack;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * This class defines a node object for searches
 * 
 * @author Don Herwig
 */

public class Node implements Comparator<Node> {
	//positions of the tiles
	private Integer[] state;
	
	private Node parent;
	
	//The action that was performed on the previous state to achieve this node
	private String action;
	
	private int pathCost;
	
	private int depth;
	
	private int cost2go;
	
	//constructor for new node object
	public Node(Integer[] stateArray, Node parentNode, String actionString, int pathLength, int nodeDepth){
		state = stateArray.clone();
		parent = parentNode;
		action = actionString;
		pathCost = pathLength;
		depth = nodeDepth;
		cost2go = this.calculateCost2Go();
	}
	
	/*
	 * This method calculates a cost to go to get to the goal state.
	 * The method achieves this by counting the number of tiles that
	 * are not in their goal position.
	 */
	private int calculateCost2Go(){
		Integer[] goal = {0,1,2,3,4,5,6,7,8,9};
		int misplaced=0;
		for(int i=0; i<9; i++){
			if(goal[i] != this.state[i]){
				misplaced++;
			}
		}
		return misplaced;
	}
	
	public int getCost2Go(){
		return cost2go;
	}
	
	/*
	 * This method takes in a node and the frontier priority queue, creates all possible 
	 * children, and adds them to the frontier queue
	 * 
	 * @param parent the node to expand
	 * @param frontier the priority queue from the A* search
	 */
	public void astarChildren(Node parent, PriorityQueue<Node> frontier){
		if(Actions.canMoveRight(parent.getState())){
			Node right = new Node(Actions.right(parent.getState()),parent,"right",parent.getPathCost() + 1, parent.getDepth() + 1);
				frontier.offer(right);
			
		}
		
		if(Actions.canMoveLeft(parent.getState())){
			Node left = new Node(Actions.left(parent.getState()),parent,"left",parent.getPathCost() + 1, parent.getDepth() + 1);
			
				frontier.offer(left);
			
		}
		
		if(Actions.canMoveDown(parent.getState())){
			Node down = new Node(Actions.down(parent.getState()),parent,"down",parent.getPathCost() + 1, parent.getDepth() + 1);
			
				frontier.offer(down);
			
		}
		
		if(Actions.canMoveUp(parent.getState())){
			Node up = new Node(Actions.up(parent.getState()),parent,"up",parent.getPathCost() + 1, parent.getDepth() + 1);
			
				frontier.offer(up);
			
		} 
	}
	
	/*
	 * This method takes a node, creates all possible children of that node, and adds
	 * the children to the frontier stack if the children aren't below the limit of the 
	 * depth limited search
	 * 
	 *@param current the node to expand
	 *@param frontier the stack containing frontier nodes
	 *@param limit the deepest allowed depth for the depth limited search
	 */
	public void iddfsChildren(Node current, Stack<Node> frontier, int limit){
		if(Actions.canMoveRight(current.getState())){
			Node right = new Node(Actions.right(current.getState()),current,"right",current.getPathCost() + 1, current.getDepth() + 1);
			if(!(right.getDepth()>=limit)){
				frontier.push(right);
			}
		}
		
		if(Actions.canMoveLeft(current.getState())){
			Node left = new Node(Actions.left(current.getState()),current,"left",current.getPathCost() + 1, current.getDepth() + 1);
			if(!(left.getDepth()>limit)){
				frontier.push(left);
			}
		}
		
		if(Actions.canMoveDown(current.getState())){
			Node down = new Node(Actions.down(current.getState()),current,"down",current.getPathCost() + 1, current.getDepth() + 1);
			if(!(down.getDepth()>limit)){
				frontier.push(down);
			}
		}
		
		if(Actions.canMoveUp(current.getState())){
			Node up = new Node(Actions.up(current.getState()),current,"up",current.getPathCost() + 1, current.getDepth() + 1);
			if(!(up.getDepth()>limit)){
				frontier.push(up);
			}
		} 
	}
	public Node getParent(){
		return parent;
	}
	
	public Integer[] getState(){
		return state;
	}
	
	public String getAction(){
		return action;	
	}
	
	public int getPathCost(){
		return pathCost;
	}
	
	public int getDepth(){
		return depth;
	}
	
	@Override
	public int compare(Node a, Node b){
		if((a.getPathCost()+a.getCost2Go()) < (b.getPathCost()+b.getCost2Go())){
			return 1;
		}else if((b.getPathCost()+b.getCost2Go()) < (a.getPathCost()+ a.getCost2Go())){
			return -1;
		}else{
			return 0;
		}
	}
	
	
	/*
	 * this override of the equals method defines two nodes as equal if their 
	 * state arrays are equal
	 */
	@Override
	public boolean equals(Object n){
		if(Arrays.equals(this.getState(),((Node) n).getState())){
			return true;
		}else{
			return false;
		}
	}
	
}
