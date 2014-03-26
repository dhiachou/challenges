import java.util.Scanner;

    public class Solution {
           
        public static void main(String[] args) {
            
        Scanner in=new Scanner(System.in);
        String R=in.next();
        int L=in.nextInt()-1;
        
        for(int j=0;j<L;j++)
        {    int i=0;
             String tmp="";
           while(i<R.length())	 
        	{
        	 int index=i;
         	 int count=1;
           while ((i+1<R.length()) && (R.charAt(i)==R.charAt(i+1)))
             {count++;
        	    i++;
             }
         	 tmp+=Integer.toString(count)+R.charAt(index);
         	 i++;
        	}
             R=tmp;
             
        }
        for(int i=0;i<R.length()-1;i++)
        System.out.print(R.charAt(i)+" ");
        System.out.print(R.charAt(R.length()-1));
        
                                               }
                          }
