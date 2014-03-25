    import java.util.Scanner;
     
    public class Solution {
           
        public static void main(String[] args) {
            
        	Scanner in=new Scanner(System.in);
            int[] tab=new int[in.nextInt()];
            for(int i=0;i<tab.length;i++)
            	tab[i]=in.nextInt();
            
            int decrease=0;
          
            for(int i=0;i<tab.length-1;i++)
            {  
            	int j=i+1;
            	while (tab[j]<tab[i])
            	{   
            		if ((tab[i]-tab[j])>decrease) decrease=tab[i]-tab[j];
            		if (j==tab.length-1) {System.out.println(-decrease);System.exit(0);}
            		j++;
            	
            	}
            }
            
            System.out.println(-decrease);
                                                    }
                           } 
