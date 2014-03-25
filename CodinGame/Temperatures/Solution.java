    import java.util.Scanner;
     
    public class Solution {
           
        public static void main(String[] args) {
            
        	Scanner in=new Scanner(System.in);
            int N=in.nextInt();
            int min=5526 ;
            
            for(int i=0;i<N;i++)
            {
            	int var=in.nextInt();
            	if (Math.abs(var)<=Math.abs(min)) min=var;
            }
            	
            if (N!=0) System.out.println(min);	
            else      System.out.println("0");	
            
                                                    }
                           }
