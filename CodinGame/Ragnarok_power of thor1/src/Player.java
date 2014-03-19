import java.util.*;
import java.io.*;
import java.math.*;

class Player {
    
    static class Coords{
        private int x,y;
        
        Coords (int x , int y){
            this.x = x;
            this.y = y;
        }  
        
        public void move(Coords destination){
            if ((destination.y - y)>0){
                System.out.print("S");
                this.y++;
            }
            else if ((destination.y - y)<0){
                System.out.print("N");
                this.y--;
            }
            
            if ((destination.x - x)>0){
                System.out.print("E");
                this.x++;
            }
            else if ((destination.x - x)<0){
                System.out.print("W");
                this.x--;
            }
            
            System.out.println();
            
        }
    }
    

    public static void main(String args[]) {
        System.err.println("Program Started");
        
        Scanner in = new Scanner(System.in);

        // Read init information from standard input, if any
        int x = in.nextInt();
        int y = in.nextInt();
        
        Coords light = new Coords(x,y);
        System.err.println("Read light coords");
        
        x = in.nextInt();
        y = in.nextInt();
        
        Coords thor = new Coords (x,y);
        System.err.println("Read Thor coords");
        
        

        while (true) {
            System.err.println("Infinite loop here");
        
            // Read information from standard input
            int e = in.nextInt();

            // Compute logic here
            thor.move(light);

            // System.err.println("Debug messages...");

            // Write action to standard output
        }
    }
}