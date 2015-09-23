import java.util.Arrays;

/*
 * This class contains possible actions to perform on a state
 * 
 * @author Don Herwig
 */
public class Actions {
	
	//this method returns whether it is possible to move the 0 square up
	public static Boolean canMoveUp(Integer[] state){
		Boolean canMove = true;
		
		//get index of zero square
		int zeroPosition = Arrays.asList(state).indexOf(0);
		
		//the 0 square can't move up if it is in array positions 0-2
		if (0 <= zeroPosition && zeroPosition <=2){
			canMove = false;
		}
		
		return canMove;
	}
	
	//this method will move the 0 square up 
	//method assumes that square is able to move up
	public static Integer[] up(Integer[] state){
		Integer[] childState = state.clone();
		
		//get index of zero square
		int zeroPosition = Arrays.asList(state).indexOf(0);
		
		//board is 3x3 grid of squares with indices 0-2 as top row 3-5 as second etc.
		//to move 0 up swap with one "above" it in the array (zeroIndex-3)
		childState[zeroPosition] = childState[zeroPosition-3];
		childState[zeroPosition-3] = 0;
		
		return childState;
		
	}
	
	//this method returns whether it is possible to move the 0 square down
		public static Boolean canMoveDown(Integer[] state){
			Boolean canMove = true;
			
			//get index of zero square
			int zeroPosition = Arrays.asList(state).indexOf(0);
			
			//the 0 square can't move down if it is in array positions 6-8
			if (6 <= zeroPosition && zeroPosition <=8){
				canMove = false;
			}
			
			return canMove;
		}
		
		//this method will move the 0 square down 
		//method assumes that square is able to move down
		public static Integer[] down(Integer[] state){
			Integer[] childState = state.clone();
			
			//get index of zero square
			int zeroPosition = Arrays.asList(state).indexOf(0);
			
			//board is 3x3 grid of squares with indices 0-2 as top row 3-5 as second etc.
			//to move 0 up swap with one "below" it in the array (zeroIndex+3)
			childState[zeroPosition] = childState[zeroPosition+3];
			childState[zeroPosition+3] = 0;
			
			return childState;
			}
		
		//this method returns whether it is possible to move the 0 square right
		public static Boolean canMoveRight(Integer[] state){
			Boolean canMove = true;
			
			//get index of zero square
			int zeroPosition = Arrays.asList(state).indexOf(0);
			
			//the 0 square can't move right if it is in array positions 2,5,8
			if (zeroPosition == 2 || zeroPosition == 5 || zeroPosition == 8){
				canMove = false;
			}
			
			return canMove;
		}
		
		//this method will move the 0 square right 
		//method assumes that square is able to move right
		public static Integer[] right(Integer[] state){
			Integer[] childState = state.clone();
					
			//get index of zero square
			int zeroPosition = Arrays.asList(state).indexOf(0);
					
			//board is 3x3 grid of squares with indices 0-2 as top row 3-5 as second etc.
			//to move 0 right swap with one to the right it in the array (zeroIndex+1)
			childState[zeroPosition] = childState[zeroPosition+1];
			childState[zeroPosition+1] = 0;
					
			return childState;
		}
		
		//this method returns whether it is possible to move the 0 square left
		public static Boolean canMoveLeft(Integer[] state){
			Boolean canMove = true;
					
			//get index of zero square
			int zeroPosition = Arrays.asList(state).indexOf(0);
					
			//the 0 square can't move left if it is in array positions 0,3,6
			if (zeroPosition == 0 || zeroPosition == 3 || zeroPosition == 6){
				canMove = false;
			}
					
			return canMove;
		}
		
		//this method will move the 0 square left 
		//method assumes that square is able to move left
		public static Integer[] left(Integer[] state){
			Integer[] childState = state.clone();
							
			//get index of zero square
			int zeroPosition = Arrays.asList(state).indexOf(0);
							
			//board is 3x3 grid of squares with indices 0-2 as top row 3-5 as second etc.
			//to move 0 right swap with one to the left it in the array (zeroIndex-1)
			childState[zeroPosition] = childState[zeroPosition-1];
			childState[zeroPosition-1] = 0;
							
			return childState;
		}
}
