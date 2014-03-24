import java.util.*;
import java.io.*;
import java.math.*;

class Player {
	
	static int nextMountain (int[] mountains){
		int r = 0;
		int length = mountains[0];
		for (int i =1 ; i< mountains.length ; i++){
			if (mountains[i] > length){
				length = mountains[i];
				r = i;
			}
		}
		System.err.print(r);
		return r;
		
	}

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Read init information from standard input, if any

        while (true) {
            // Read information from standard input
            int Sx = in.nextInt();	//vessel position
            int Sy = in.nextInt();
            
            System.err.println("Sx = " + Sx);
            
            int[] MH = new int[8];
            
            for (int i =0 ; i<8 ; i++){
            	MH[i] = in.nextInt();
            }
            
            

            // System.err.println("Debug messages...");

            // Write action to standard output
            if (Sx == nextMountain(MH)){
            	System.out.println("FIRE");
            }
            else
            	System.out.println("HOLD");
        }
    }
}