    import java.util.Scanner;
     
    public class Solution {
           
        public static void main(String[] args) {
            
        	 Scanner in=new Scanner(System.in);
           int N=in.nextInt();
           int Q=in.nextInt();
           in.nextLine();
        	
    //Sorting List will be better 
           
        	String[][] matrix=new String[2][N];
        	String tmp []=new String[2];
        	
        	for(int i=0;i<N;i++)
        	{
        		String str=in.nextLine();
				    tmp=str.split(" ");
        		matrix[0][i]=tmp[0].toLowerCase();
        		matrix[1][i]=tmp[1];
        	}
        
        	
        	for(int i=0;i<Q;i++)
        	{
        		String str=in.nextLine();
        		
        		if (str.indexOf(".")>=0) {str=str.substring(str.lastIndexOf(".")+1,str.length()).toLowerCase();
        		                            
        		 						   boolean b=true;
        								   for(int j=0;j<N;j++)
        		                            { 
        		                        	  if (str.equals(matrix[0][j])) {System.out.println(matrix[1][j]);
        		                        	  								b=false;break;}
        		                        	  
        		                        	  }
        		                         
        		                          if (b) System.out.println("UNKNOWN"); 
        									}
        		else
        			System.out.println("UNKNOWN");
        	    
        	
        	}

                                                    }
                           }

