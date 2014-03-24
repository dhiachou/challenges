import java.util.*;
import java.io.*;
import java.math.*;

class Player {
	
	
	static boolean wallOnRight(String[] maze, String dir, int[] pos){
		if (dir.equals("down") &&  maze[pos[0]].charAt(pos[1]-1)=='#'  
				|| dir.equals("right") && maze[pos[0]+1].charAt(pos[1])=='#' 
				|| dir.equals("left") && maze[pos[0]-1].charAt(pos[1])=='#' 
				|| dir.equals("up") && maze[pos[0]].charAt(pos[1]+1)=='#'){
			System.err.println("wall on right ! ");
			return true;
		}
		else return false;
	}
	
	static boolean wallOnLeft(String[] maze, String dir, int[] pos){
		if (dir.equals("down") &&  maze[pos[0]].charAt(pos[1]+1)=='#'  
				|| dir.equals("right") && maze[pos[0]-1].charAt(pos[1])=='#' 
				|| dir.equals("left") && maze[pos[0]+1].charAt(pos[1])=='#' 
				|| dir.equals("up") && maze[pos[0]].charAt(pos[1]-1)=='#'){
			System.err.println("wall on left ! ");
			return true;
		}
		else return false;
	}
	
	static boolean wallOnFront(String[] maze, String dir, int[] pos){
		if (dir.equals("down") &&  maze[pos[0]+1].charAt(pos[1])=='#'  
				|| dir.equals("right") && maze[pos[0]].charAt(pos[1]+1)=='#' 
				|| dir.equals("left") && maze[pos[0]].charAt(pos[1]-1)=='#' 
				|| dir.equals("up") && maze[pos[0]-1].charAt(pos[1])=='#'){
			System.err.println("wall on front ! ");
			return true;
		}
		else return false;
	}
	
	static boolean wallOnBack(String[] maze, String dir, int[] pos){
		if (dir.equals("down") &&  maze[pos[0]-1].charAt(pos[1])=='#'  
				|| dir.equals("right") && maze[pos[0]].charAt(pos[1]-1)=='#' 
				|| dir.equals("left") && maze[pos[0]].charAt(pos[1]+1)=='#' 
				|| dir.equals("up") && maze[pos[0]+1].charAt(pos[1])=='#'){
			System.err.println("wall on back ! ");
			return true;
		}
		else return false;
	}

	static String turnRight(String dir){
		System.err.println("Turning right");
		if(dir.equals("down"))			return "left";
		else if(dir.equals("up"))		return "right";
		else if(dir.equals("left"))		return "up";
		else if(dir.equals("right"))	return "down";
		
		return null;		
	}
	
	static String turnLeft(String dir){
		System.err.println("Turning left");
		if(dir.equals("down"))			return "right";
		else if(dir.equals("up"))		return "left";
		else if(dir.equals("left"))		return "down";
		else if(dir.equals("right"))	return "up";
		
		return null;		
	}
	
	static String turnTwist(String dir){
		System.err.println("Turning twist");
		if(dir.equals("down"))			return "up";
		else if(dir.equals("up"))		return "down";
		else if(dir.equals("left"))		return "right";
		else if(dir.equals("right"))	return "left";
		
		return null;		
	}
	
	static String walkForward(String dir, int[] pos, String path){
		System.err.println("walking forward");
		String myPos = pos[0] + " " + pos[1]+ "\n"; 
		if(path.contains(myPos)) path = path.substring(0, path.indexOf(myPos));
		path = path+myPos;
		System.out.println(dir.toUpperCase());
		return path;
	}
	
	static boolean cFound(String[] maze,int[] pos){
		int r=0 , c=0;
		for (String str : maze){
			if(str.contains("C")) {
				c = str.indexOf('C');
				break;
			}
			r++;
		}
		if (pos[0] == r && pos[1] == c) return true;
		
		return false;
	}
	
	static String[] move(String[] maze, String dir , int[] pos, String path){
		if (!wallOnFront(maze, dir, pos) && wallOnRight(maze, dir, pos)) path = walkForward(dir,pos,path);
		else if(!wallOnRight(maze, dir, pos)){
			dir = turnRight(dir);
			path = walkForward(dir,pos,path);
		}
		else if (wallOnFront(maze, dir, pos)&& wallOnRight(maze, dir, pos)&& !wallOnLeft(maze, dir, pos)){
			dir = turnLeft(dir);
			path = walkForward(dir,pos,path);
		}
		else{
			dir = turnTwist(dir);
			path = walkForward(dir,pos,path);
		}
		String[] r ={dir,path} ;
		return r;
		
	}
	
	static String moveBack(int[] pos , String path){
		String[] coords = path.split("\n");
		int[] lastPos = new int[2];
		
		System.err.println("Going back to " + coords[coords.length-1]);
		
		lastPos[0] = Integer.valueOf(coords[coords.length-1].split(" ")[0]);
		lastPos[1] = Integer.valueOf(coords[coords.length-1].split(" ")[1]);
		
		System.err.println("Got coordinates");
		
		if (path.contains("\n"))
			path = path.substring(0,path.lastIndexOf('\n', path.length()-1));
		
		
		if(lastPos[0]>pos[0]){
			System.out.println("DOWN");
		}
		else if(lastPos[0]<pos[0]){
			System.out.println("UP");
		}
		else if(lastPos[1]<pos[1]){
			System.out.println("LEFT");
		}
		else if(lastPos[1]>pos[1]){
			System.out.println("RIGHT");
		}
		
		return path;
	}
	
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Read init information from standard input, if any
        int r = in.nextInt(); //maze dimensions : rows
        int c = in.nextInt(); // columns
        int a = in.nextInt(); // steps after the alarm
        
        System.err.println(r + " " + c + " " + a );
        
       

        String [] maze = new String[r];
        
        String phase = "init";
        String direction = "up";
        String path = new String();
        while (true) {
            // Read information from standard input
            int kr = in.nextInt(); //my position : row
            int kc = in.nextInt(); // column
            in.nextLine();
            System.err.println("position: " + kr + " , "+ kc );
            
            int [] pos = { kr, kc };
            
            for (int i =0 ; i < r ; i++){
            	maze[i] = in.nextLine();
            	
            	//System.err.println(maze[i]);
            }

            //initializing to a wall
            if (phase.equals("init")){ 
                System.err.println("Entered the init phase");
            	if(wallOnRight(maze,direction,pos)){ //we already have a wall on our right
            		phase = "search";
            		
            	}
            	else if (wallOnFront(maze,direction,pos)){ // a wall ahead ! turn to make it on our right ! 
            		direction = turnRight(direction);
            		phase = "search";
            	}
            	else if (wallOnBack(maze,direction,pos)){ //a wall behind ! make it on our right
            		direction  = turnLeft(direction);
            		phase = "search";
            	}
            	else if(wallOnLeft(maze,direction,pos)){
            		direction = turnTwist(direction);
            		phase = "search";
            	}
            	else 
            		path = walkForward(direction,pos,path);
            }
            
            if(phase.equals("search") ){ // the search for control room phase
            	System.err.println("Entered the search phase");
            	if(cFound(maze,pos)){
            		phase = "goBack";
            		path = path.substring(0,path.lastIndexOf('\n', path.length()-1));
            	}
            	else{
            		String[] ret = move(maze,direction,pos,path);
                	direction = ret[0];
                	path  = ret[1];
            	}
            	
            }
            
            if(phase.equals("goBack")){
                System.err.println("Entered the goBack phase");
            	System.err.println(path);
            	path = moveBack(pos, path);
            }

            // System.err.println("Debug messages...");

            // Write action to standard output
            
        }
    }
}